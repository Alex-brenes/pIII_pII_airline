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

import aerolinea.logica.Vuelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO extends AbstractDAO<Vuelo, String> {

    public VueloDAO(){
        super();
    }
    
    @Override
    public void add(Vuelo s) throws Throwable {
        String query = "INSER INTO Vuelo (idVuelo, dia, hora, origen, destino, avion) "
                + "VALUES('%s', '%s', '%s', '%s', '%s', '%s')";
        query = String.format(query,
                s.getIdVuelo(),
                s.getDia(),
                //Ajustar el ingreso de la hora a la base de datos con el formato de SQL
                s.getHora().toString(),
                s.getOrigen().getNombre(),
                s.getDestino().getNombre(),
                s.getAvion().getId()
        );
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El vuelo ya existe");
        }
    }

    @Override
    public void delete(Vuelo s) throws Throwable {
        String query = "DELETE FROM Vuelo WHERE idVuelo='%s'";
        query = String.format(query, s.getIdVuelo());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El vuelo no existe");
        }
    }

    @Override
    public Vuelo get(String s) throws Throwable { //Búsqueda por id
        String query = "SELECT * "
                + "FROM Vuelo v "
                + "WHERE v.idVuelo='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El vuelo no existe");
        }
    }

    @Override
    public void update(Vuelo s) throws Throwable {
        String sql = "UPDATE Vuelo SET dia='%s', hora='%s', origen='%s', destino='%s', avion='%s' "
                + "where idVuelo='%s'";
        // Actualiza la abreviatura del pais
        sql = String.format(sql,
                s.getDia(),
                s.getHora().toString() /*cambiar el formato de la hora*/,
                s.getOrigen().getNombre(),
                s.getDestino().getNombre(),
                s.getAvion().getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El vuelo no existe");
        }
    }

    @Override
    public List<Vuelo> searh(String s) throws Throwable {
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String query = "SELECT * "
                    + "FROM Vuelo v "
                    + "WHERE v LIKE '%%%s%%'";
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
    public Vuelo instancia(ResultSet rs) throws Throwable {
                try {
            String s;
            Vuelo v = new Vuelo();
            v.setIdVuelo(rs.getString("idVuelo"));
            v.setDia(rs.getString("dia"));
            v.setHora(rs.getDate("hora"));
            //Por ahora, creo que se debería crear toda la ciudad
            v.setOrigen(new aerolinea.logica.Ciudad(rs.getString("origen")));
            v.setDestino(new aerolinea.logica.Ciudad(rs.getString("destino")));
            //Por ahora solo se le pone la id
            v.setAvion(new aerolinea.logica.Avion(rs.getString("avion")));
            return v;
        } catch (SQLException ex) {
            return null;
        }
    }

}
