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

import aerolinea.logica.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ReservaDAO implements DAO<Reserva, Integer> {

    private RelDatabase db;

    @Override
    public void add(Reserva s) throws Throwable {
        String query = "INSER INTO Reserva (idReserva, cantidad, documento, viaje, formaPago, usuario) "
                + "values('%s','%s','%s','%s','%s','%s')";
        query = String.format(query,
                s.getIdReserva(),
                s.getCantidad(),
                s.getDocumento(),
                s.getViaje(),
                s.getFormapago(),
                s.getUsuario().getIdUsuario());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La reserva ya existe");
        }
    }

    @Override
    public void delete(Reserva s) throws Throwable {
        String query = "DELETE FROM Reserva WHERE idReserva='%s'";
        query = String.format(query, s.getIdReserva());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La reserva no existe");
        }
    }

    @Override
    public Reserva get(Integer s) throws Throwable {
        String query = "SELECT * "
                + "FROM Reserva r "
                + "WHERE r.idReserva='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("La reserva no existe");
        }
    }

    @Override
    public void update(Reserva s) throws Throwable {
        String sql = "UPDATE Reserva SET cantidad='%s', documento='%s', viaje='%s', formaPago='%s', usuario='%s' "
                + "where idReserva='%s'";
        sql = String.format(sql,
                s.getCantidad(),
                s.getDocumento(),
                s.getViaje(),
                s.getFormapago(), 
                s.getUsuario());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La reserva no existe");
        }
    }

    @Override
    public List<Reserva> searh(Integer s) throws Throwable { // Busqueda por usuario
                List<Reserva> resultado = new ArrayList<Reserva>();
        try {
            String query = "SELECT * "
                    + "FROM Reserva r "
                    + "WHERE r.usuario LIKE '%%%s%%'";
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
    public Reserva instancia(ResultSet rs) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
