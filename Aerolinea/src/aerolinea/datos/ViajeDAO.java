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

import aerolinea.logica.Viaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ViajeDAO extends AbstractDAO<Viaje, Integer> {

    @Override
    public void add(Viaje s) throws Throwable {
        String query = "INSER INTO Viaje v (idViaje, fecha, precio, disponibles, vuelo) "
                + "values('%s', '%s', '%s', '%s', '%s')";
        query = String.format(query,
                s.getIdViaje(),
                s.getFecha(),
                s.getPrecio(),
                s.getDisponibles(),
                s.getVuelo().getIdVuelo());
        int count = db.executeUpdate(query);
        //Cargar las reservas a la base de datos

        if (count == 0) {
            throw new Exception("El vuelo ya existe");
        }
    }

    @Override
    public void delete(Viaje s) throws Throwable {
        String query = "DELETE FROM Viaje WHERE idViaje='%s'";
        query = String.format(query, s.getIdViaje());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El viaje no existe");
        }
    }

    @Override
    public Viaje get(Integer s) throws Throwable {
        String query = "SELECT * "
                + "FROM Viaje v "
                + "WHERE v.idViaje='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El viaje no existe");
        }
    }

    @Override
    public void update(Viaje s) throws Throwable {
        String query = "UPDATE Viaje SET fecha='%s', precio='%s', disponibles='%s', vuelo ='%s' "
                + "where idViaje='%s'";
        // HAY QUE CORREGIR ALGO CON LAS FECHAS
        query = String.format(query, s.getFecha().toString(), s.getPrecio(), s.getDisponibles(), s.getVuelo().getIdVuelo());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El viaje no existe");
        }
    }

    @Override
    public List<Viaje> searh(Integer s) throws Throwable {
        List<Viaje> resultado = new ArrayList<Viaje>();
        try {
            String query = "SELECT * "
                    + "FROM Viaje v "
                    + "WHERE v.idViaje LIKE '%%%s%%'";
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
    public Viaje instancia(ResultSet rs) throws Throwable {
        try {
            Viaje v = new Viaje();
            //Cargar sus reservas
            v.setIdViaje(Integer.parseInt(rs.getString("idViaje")));
            v.setPrecio(Float.parseFloat(rs.getString("precio")));
            v.setDisponibles(Integer.parseInt(rs.getString("disponibles")));
            // No creo que esto pueda ir así
            v.setVuelo(new aerolinea.logica.Vuelo(rs.getString("vuelo")));
            

            return v;
        } catch (SQLException ex) {
            return null;
        }
    }

}
