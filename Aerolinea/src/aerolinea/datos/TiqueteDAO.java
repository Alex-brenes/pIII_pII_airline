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

import aerolinea.logica.Tiquete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class TiqueteDAO extends AbstractDAO<Tiquete, Integer> {

    @Override
    public void add(Tiquete s) throws Throwable {
        // TENGO LA DUDA CON LO DEL NÚMERO DE ASIENTO COMO PRIMARY KEY DE TIQUETE
        String query = "INSER INTO Tiquete (numeroAsiento, reserva) "
                + "VALUES('%s', '%s')";
        query = String.format(query, s.getNumeroAsiento(), s.getReserva());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad ya existe");
        }
    }

    @Override
    public void delete(Tiquete s) throws Throwable {
        String query = "DELETE FROM Tiquete WHERE numeroAsiento='%s'";
        query = String.format(query, s.getNumeroAsiento());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public Tiquete get(Integer s) throws Throwable {
        // CAMBIAR LLAVE PRIMARIA
        String query = "SELECT * "
                + "FROM Tiquete t "
                + "WHERE t.numeroAsiento='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public void update(Tiquete s) throws Throwable {
        String sql = "UPDATE Tiquete SET reserva='%s' "
                + "where numeroAsiento='%s'";
        // Actualiza la abreviatura del pais
        sql = String.format(sql, s.getReserva().getIdReserva(), s.getNumeroAsiento());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public List<Tiquete> searh(Integer s) throws Throwable {
        List<Tiquete> resultado = new ArrayList<Tiquete>();
        try {
            String query = "SELECT * "
                    + "FROM Tiquete t "
                    + "WHERE t.numeroAsiento LIKE '%%%s%%'";
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
    public Tiquete instancia(ResultSet rs) throws Throwable {
        try {
            String s;
            Tiquete c = new Tiquete();
            c.setNumeroAsiento(Integer.parseInt(rs.getString("numeroAsiento")));
            c.setReserva(new aerolinea.logica.Reserva(Integer.parseInt(rs.getString("reserva"))));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
