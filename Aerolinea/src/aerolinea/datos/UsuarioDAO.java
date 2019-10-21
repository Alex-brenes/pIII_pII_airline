// UsuarioDAO.java
// Author: José Alexander Brenes Brenes
// Description: Access to the Usuario table.
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

import aerolinea.logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario, Integer> {

    private RelDatabase db;

    @Override
    public void add(Usuario s) throws Throwable {
        String query = "INSER INTO Usuario (idUsuario, email, password, firstName, lastName, dateOfBirth, address, workPhone, phone) "
                + "values('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        query = String.format(query,
                s.getIdUsuario(),
                s.getEmail(),
                s.getPassword(),
                s.getFirstName(),
                s.getLastName(),
                s.getDateOfBirth(),
                s.getAddress(),
                s.getWorkPhone(),
                s.getPhone());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El usuario ya existe");
        }
    }

    @Override
    public void delete(Usuario s) throws Throwable {
        String query = "DELETE FROM Usuario WHERE idUsuario='%s'";
        query = String.format(query, s.getIdUsuario());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public Usuario get(Integer s) throws Throwable {
        String query = "SELECT * "
                + "FROM Usuario u "
                + "WHERE u.idUsuario='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public void update(Usuario s) throws Throwable {
        String sql = "UPDATE USUARIO SET email='%s', password='%s', firstName='%s', lastName='%s', dateOfBirth='%s', address='%s', workPhone='%s', phone='%s' "
                + "where idFormaPago='%s'";
        sql = String.format(sql,
                s.getEmail(),
                s.getPassword(),
                s.getFirstName(),
                s.getLastName(),
                s.getDateOfBirth(),
                s.getAddress(),
                s.getWorkPhone(),
                s.getPhone(),
                s.getIdUsuario());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public List<Usuario> searh(Integer s) throws Throwable{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario instancia(ResultSet rs) throws Throwable {
        try {
            String s;
            Usuario c = new Usuario();
            c.setEmail(rs.getString("email"));
            c.setPassword(rs.getString("password"));
            c.setFirstName(rs.getString("firstName"));
            c.setLastName(rs.getString("lastName"));
            c.setDateOfBirth(rs.getString("dateOfBirth"));
            c.setAddress(rs.getString("address"));
            c.setWorkPhone(rs.getString("worPhone"));
            c.setPhone(rs.getString("phone"));
            c.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
            // Ver si cargar también las reservas
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
