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

    public TiqueteDAO() {
        super();
    }

    @Override
    public void add(Tiquete s) throws Throwable {
        String query = "SELECT * FROM reserva ORDER BY idReserva DESC LIMIT 1";
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            query = "INSERT INTO Tiquete (fila,asiento,reserva) "
                    + "VALUES('%s', %s, %s)";
            query = String.format(query,
                    s.getFila(),
                    s.getAsiento(),
                    rs.getInt("idReserva"));
            int count = db.executeUpdate(query);
            if (count == 0) {
                throw new Exception("El tiquete ya existe");
            }

        }
    }

    @Override
    public void delete(Tiquete s) throws Throwable {
        String query = "DELETE FROM Tiquete WHERE idTiquete='%s'";
        query = String.format(query, s.getIdTiquete());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El tiquete no existe");
        }
    }

    @Override
    public Tiquete get(Integer s) throws Throwable {
        String query = "SELECT * "
                + "FROM Tiquete t "
                + "WHERE t.idTiquete='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El tiquete no existe");
        }
    }

    @Override
    public void update(Tiquete s) throws Throwable {
        String query = "UPDATE Tiquete SET fila ='%s', asiento=%s, reserva='%s' "
                + "where idTiquete='%s'";
        query = String.format(query,
                s.getFila(),
                s.getAsiento(),
                s.getReserva().getIdReserva(),
                s.getIdTiquete());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El tiquete no existe");
        }
    }

    @Override
    public List<Tiquete> searh(Integer s) throws Throwable { // Búsqueda por idTiquete
        List<Tiquete> resultado = new ArrayList<Tiquete>();
        try {
            String query = "SELECT * "
                    + "FROM Tiquete t "
                    + "WHERE t.idTiquete LIKE '%%%s%%'";
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
            c.setIdTiquete(Integer.parseInt(rs.getString("idTiquete")));
            c.setAsiento(Integer.parseInt(rs.getString("asiento")));
            c.setFila((rs.getString("fila")));
            //Por ahora
            c.setReserva(new aerolinea.logica.Reserva(Integer.parseInt(rs.getString("reserva"))));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
