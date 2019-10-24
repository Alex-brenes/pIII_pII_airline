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
public class PaisDAO extends AbstractDAO<Pais, String> {

    public PaisDAO() {
        super();
    }

    @Override
    public void add(Pais p) throws Throwable {
        String query = "INSER INTO Pais (abreviatura, nombre) "
                + "values('%s', '%s')";
        query = String.format(p.getAbreviatura(), p.getNombre());
        int count = db.executeUpdate(query);
        //Cargar las ciudades
//        for(Ciudad c : p.getCiudadList()){
//            
//        }
        if (count == 0) {
            throw new Exception("El país ya existe");
        }
    }

    @Override
    public void delete(Pais p) throws Throwable {
        String query = "DELETE FROM Pais WHERE abreviatura='%s'";
        query = String.format(query, p.getAbreviatura());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El país no existe");
        }
    }

    @Override
    public Pais get(String ab) throws Throwable {
        String query = "SELECT * "
                + "FROM Pais p "
                + "WHERE p.abreviatura='%s'";
        query = String.format(query, ab);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El país no existe");
        }
    }

    @Override
    public void update(Pais p) throws Throwable {
        String query = "UPDATE Pais SET nombre='%s' "
                + "where abreviatura='%s'";
        query = String.format(query, p.getNombre(), p.getAbreviatura());

        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El país no existe");
        }
    }

    @Override
    public List<Pais> searh(String ab) throws Throwable { // Búsqueda por abreviatura
        List<Pais> resultado = new ArrayList<Pais>();
        try {
            String query = "SELECT * "
                    + "FROM Pais p "
                    + "WHERE p.abreviatura LIKE '%%%s%%'";
            query = String.format(query, ab);
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
    public Pais instancia(ResultSet rs) {
        try {
            String s;
            Pais p = new Pais();
            p.setAbreviatura(rs.getString("abreviatura"));
            p.setNombre(rs.getString("nombre"));
            // VER SI TAMBIÉN CARGAR LAS CIUDADES
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
