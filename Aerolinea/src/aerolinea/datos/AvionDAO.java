
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

import aerolinea.logica.Avion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO extends AbstractDAO<Avion, String> {

    public AvionDAO(){
        super();
    }
    
    @Override
    public void add(Avion s) throws Throwable {
        String query = "INSERT INTO Avion (id, tipoAvion) "
                + "VALUES('%s', '%s')";
        query = String.format(query, s.getId(), s.getTipoavion().getIdTipoAvion());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El avión ya existe");
        }
    }

    @Override
    public void delete(Avion s) throws Throwable {
        String query = "DELETE FROM Avion WHERE id='%s'";
        query = String.format(query, s.getId());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El avión no existe");
        }
    }

    @Override
    public Avion get(String s) throws Throwable {
        String query = "SELECT * "
                + "FROM Avion a "
                + "WHERE a.id='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El avión no existe");
        }
    }

    @Override
    public void update(Avion s) throws Throwable {
        String query = "UPDATE Avion SET tipoAvion='%s' "
                + "where id='%s'";
        // Actualiza la abreviatura del pais
        query = String.format(query, s.getTipoavion().getIdTipoAvion(), s.getId());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El avión no existe");
        }
    }

    @Override
    public List<Avion> searh(String s) throws Throwable { //Búsqueda por id
        List<Avion> resultado = new ArrayList<Avion>();
        try {
            String query = "SELECT * "
                    + "FROM Avion a "
                    + "WHERE a.id LIKE '%%%s%%'";
            query = String.format(query, s);
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    @Override
    public Avion instancia(ResultSet rs) throws Throwable {
        try {
            String s;
            Avion c = new Avion();
            c.setId(rs.getString("id"));
            // Por ahora
            c.setTipoavion(new aerolinea.logica.Tipoavion(rs.getString("tipoAvion")));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
