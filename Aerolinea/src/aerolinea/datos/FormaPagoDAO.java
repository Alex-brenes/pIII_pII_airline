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

import aerolinea.logica.Formapago;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class FormaPagoDAO extends AbstractDAO<Formapago, String> {

    public FormaPagoDAO() {
        super();
    }

    @Override
    public void add(Formapago s) throws Throwable {
        String query = "INSERT INTO FormaPago (idFormaPago,nombreFormaPago) "
                + "values('%s','%s')";
        query = String.format(query, s.getIdFormaPago(), s.getNombreFormaPago());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La forma de pago ya existe");
        }
    }

    @Override
    public void delete(Formapago s) throws Throwable {
        String query = "DELETE FROM FormaPago WHERE idFormaPago='%s'";
        query = String.format(query, s.getIdFormaPago());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La forma de pago no existe");
        }
    }

    @Override
    public Formapago get(String s) throws Throwable {
        String query = "SELECT * "
                + "FROM FormaPago f "
                + "WHERE f.idFormaPago='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("La forma de pago no existe");
        }
    }

    @Override
    public void update(Formapago s) throws Throwable {
        String query = "UPDATE FormaPago SET nombreFormaPago='%s' "
                + "where idFormaPago='%s'";
        query = String.format(query, s.getNombreFormaPago(), s.getIdFormaPago());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("La forma de pago no existe");
        }
    }

    @Override
    public List<Formapago> searh(String s) throws Throwable { //Búsqueda por id
        List<Formapago> resultado = new ArrayList<Formapago>();
        try {
            String query = "SELECT * "
                    + "FROM Formapago f  "
                    + "where f.idFormaPago like '%%%s%%'";
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
    public List<Formapago> search() throws Throwable {
        List<Formapago> resultado = new ArrayList<Formapago>();
        try {
            String query = "SELECT * "
                    + "FROM Formapago f";
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }

        } catch (SQLException ex) {
        }
        return resultado;

    }

    @Override
    public Formapago instancia(ResultSet rs) throws Throwable {
        try {
            Formapago c = new Formapago();
            c.setIdFormaPago(rs.getString("idFormaPago"));
            c.setNombreFormaPago(rs.getString("nombreFormaPago"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
