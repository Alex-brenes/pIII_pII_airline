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
public class CiudadDAO implements DAO<Ciudad, String> {

    private RelDatabase db;

    @Override
    public void add(Ciudad c) throws Throwable {
        String query = "INSER INTO Ciudad (nombre) "
                + "values('%s')";
        query = String.format(c.getNombre());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad ya existe");
        }
    }

    @Override
    public void delete(Ciudad c) throws Throwable {
        String query = "DELETE FROM Ciudad WHERE nombre='%s'";
        query = String.format(query, c.getNombre());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public Ciudad get(String nombre) throws Throwable {
        String query = "SELECT * "
                + "FROM Ciudad c "
                + "WHERE c.nombre='%s'";
        query = String.format(query, nombre);
        ResultSet rs = db.executeQuery(query);
        // VER SI TAMBIÉN CARGAR LOS PAÍSES
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public void update(Ciudad c) throws Throwable {
        String sql = "UPDATE Ciudad SET nombre='%s' "
                + "where nombre='%s'";
        sql = String.format(sql, c.getNombre(), c.getNombre());
        // CREO QUE HACE FALTA UNA LLAVE PRIMARIA DIFERENTE PARA LA CIUDAD
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public List<Ciudad> searh(String nombre) {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String query = "SELECT * "
                    + "FROM Ciudad c "
                    + "WHERE c.nombre LIKE '%%%s%%'";
            query = String.format(query, nombre);
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
        // Returns a 'Pais' new reference.
    @Override
    public Ciudad instancia(ResultSet rs) {
        try {
            String s;
            Ciudad c = new Ciudad();
            c.setNombre(rs.getString("nombre"));
            Pais p = new Pais();
            p.setAbreviatura(rs.getString("abreviaturaPais"));
            p.getCiudadList().add(c);
            c.setPais(p);
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
