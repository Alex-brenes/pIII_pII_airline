/*
 * Copyright (C) 2019 pc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package aerolinea.datos;

import aerolinea.logica.Pais;
import aerolinea.logica.Ciudad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class CiudadDAO extends AbstractDAO<Ciudad, String> {

    public CiudadDAO() {
        super();
    }

    @Override
    public void add(Ciudad c) throws Throwable {
        String query = "INSERT INTO Ciudad (nombreCiudad, abreviaturaPais) "
                + "VALUES('%s', '%s')";
        query = String.format(query, c.getNombre(), c.getPais().getAbreviatura());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad ya existe");
        }
    }

    @Override
    public void delete(Ciudad c) throws Throwable {
        String query = "DELETE FROM Ciudad WHERE nombreCiudad='%s'";
        query = String.format(query, c.getNombre());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public Ciudad get(String nombre) throws Throwable {
        String query = "SELECT * "
                + "FROM Ciudad c INNER JOIN Pais p ON c.abreviaturaPais = p.abreviatura "
                + "WHERE c.nombreCiudad='%s'";
        query = String.format(query, nombre);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public void update(Ciudad c) throws Throwable {
        String query = "UPDATE Ciudad SET abreviaturaPais='%s' "
                + "WHERE nombreCiudad='%s'";
        // Actualiza la abreviatura del pais
        query = String.format(query, c.getPais().getAbreviatura(), c.getNombre());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public List<Ciudad> searh(String nombre) throws Throwable {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String query = "SELECT * "
                    + "FROM Ciudad c INNER JOIN Pais p ON c.abreviaturaPais = p.abreviatura "
                    + "WHERE c.nombreCiudad LIKE '%%%s%%'";
            query = String.format(query, nombre);
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    @Override
    public List<Ciudad> search() throws Throwable {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String query = "SELECT * FROM Ciudad c "
                    + "INNER JOIN Pais p ON c.abreviaturaPais = p.abreviatura";
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    // Returns a 'Ciudad' new reference.
    @Override
    public Ciudad instancia(ResultSet rs) {
        try {
            Ciudad c = new Ciudad();
            c.setNombre(rs.getString("nombreCiudad"));
            Pais p = new Pais();
            p.setAbreviatura(rs.getString("abreviaturaPais"));
            p.setNombre(rs.getString("nombrePais"));
            p.getCiudadList().add(c);
            c.setPais(p);
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
