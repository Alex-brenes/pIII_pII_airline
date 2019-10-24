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
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends AbstractDAO<Usuario, Integer> {

    public UsuarioDAO() {
        super();
    }

    @Override
    public void add(Usuario s) throws Throwable {
        //Se quita idUsuario porque es AUTO INCREMENT
        String query = "INSER INTO Usuario (idUsuario, email, contrasenna, nombre, apellido, fechaNacimiento, direccion, telefonoTrabajo, telefono, esAdmin) "
                + "values('%s','%s','%s','%s','%s','%s','%s','%s','%s', '%s')";
        query = String.format(query,
                s.getIdUsuario(),
                s.getEmail(),
                s.getContrasenna(),
                s.getNombre(),
                s.getApellido(),
                s.getFechaNacimiento(),
                s.getDireccion(),
                s.getTelefonoTrabajo(),
                s.getTelefono(),
                s.getEsAdmin());
        int count = db.executeUpdate(query);
        // CARGAR TODAS LAS RESERVAS DE ESTE USUARIO si no es admin
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
        String query = "UPDATE USUARIO SET email='%s', contrasenna='%s', nombre='%s', apellido='%s', fechaNacimiento='%s', direccion='%s', telefonoTrabajo='%s', telefono='%s', admin='%s' "
                + "WHERE idUsuario='%s'";
        query = String.format(query,
                s.getEmail(),
                s.getContrasenna(),
                s.getNombre(),
                s.getApellido(),
                s.getFechaNacimiento(),
                s.getDireccion(),
                s.getTelefonoTrabajo(),
                s.getTelefono(),
                s.getEsAdmin(),
                s.getIdUsuario());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public List<Usuario> searh(Integer s) throws Throwable {
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            String query = "SELECT * "
                    + "FROM Usuario u "
                    + "WHERE u.idUsuario LIKE '%%%s%%'";
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
    public Usuario instancia(ResultSet rs) throws Throwable {
        try {
            String s;
            Usuario c = new Usuario();
            c.setEmail(rs.getString("email"));
            c.setContrasenna(rs.getString("contrasenna"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setFechaNacimiento(rs.getString("fechaNacimiento"));
            c.setDireccion(rs.getString("direccion"));
            c.setTelefonoTrabajo(rs.getString("telefonoTrabajo"));
            c.setTelefono(rs.getString("telefono"));
            c.setEsAdmin(rs.getBoolean("admin"));
            c.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

}
