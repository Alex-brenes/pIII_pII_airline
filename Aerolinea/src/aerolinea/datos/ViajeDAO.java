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
import aerolinea.logica.Reserva;
import aerolinea.logica.Tiquete;
import aerolinea.logica.Usuario;
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

    public ViajeDAO() {
        super();
    }

    @Override
    public void add(Viaje s) throws Throwable {
        String query = "INSERT INTO Viaje (fecha, precio, disponibles, vuelo) "
                + "values('%s', %s, %s, '%s')";
        query = String.format(query,
                this.sqlDatetimeFormat(s.getFecha()),
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
    public List<Viaje> search() throws Throwable {
        List<Viaje> resultado = new ArrayList<Viaje>();
        try {
            String query = "SELECT * FROM Viaje v INNER JOIN Vuelo o ON v.vuelo=o.idVuelo "
                    + "INNER JOIN Avion a ON o.avion=a.id INNER JOIN TipoAvion t "
                    + "ON a.tipoAvion = t.idTipoAvion";
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                Viaje v = this.instancia(rs);
                v.setReservaList(getReserva(v));
                resultado.add(v);
            }
        } catch (SQLException ex) {
        }
        return resultado;
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
                + "FROM Viaje v INNER JOIN Vuelo o ON v.vuelo=o.idVuelo "
                + "INNER JOIN Avion a ON o.avion=a.id INNER JOIN TipoAvion t "
                + "ON a.tipoAvion = t.idTipoAvion "
                + "WHERE v.idViaje='%s'";
        query = String.format(query, s);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            Viaje v = this.instancia(rs);
            v.setReservaList(getReserva(v));
            return v;
        } else {
            throw new Exception("El viaje no existe");
        }
    }

    @Override
    public void update(Viaje s) throws Throwable {
        String query = "UPDATE Viaje SET fecha='%s', precio=%s, disponibles=%s, vuelo ='%s' "
                + "WHERE idViaje=%s";
        query = String.format(query,
                this.sqlDatetimeFormat(s.getFecha()),
                s.getPrecio(),
                s.getDisponibles(),
                s.getVuelo().getIdVuelo(),
                s.getIdViaje());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El viaje no existe");
        }
    }

    public List<Viaje> search(Viaje v, String date) throws Throwable {
        List<Viaje> resultado = new ArrayList<Viaje>();
        try {
            String query = "SELECT * "
                    + "FROM Viaje v INNER JOIN Vuelo o ON v.vuelo=o.idVuelo "
                    + "INNER JOIN Avion a ON o.avion=a.id INNER JOIN TipoAvion t "
                    + "ON a.tipoAvion = t.idTipoAvion "
                    + "WHERE v.precio <= '%s' AND v.fecha LIKE '%s' "
                    + "AND o.origen LIKE '%%%s%%' AND o.destino LIKE '%%%s%%' "
                    + "AND v.disponibles "
                    + ">= '%s' ";
            query = String.format(query,
                    this.priceParam(v.getPrecio()),
                    date,
                    (v.getVuelo().getOrigen() != null
                    ? v.getVuelo().getOrigen().getNombre()
                    : ""),
                    (v.getVuelo().getDestino() != null
                    ? v.getVuelo().getDestino().getNombre()
                    : ""),
                    this.availableParam(v.getDisponibles()));
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                Viaje vu = this.instancia(rs);
                vu.setReservaList(getReserva(vu));
                resultado.add(vu);
                //resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    @Override
    public List<Viaje> searh(Integer s) throws Throwable {
        List<Viaje> resultado = new ArrayList<Viaje>();
        try {
            String query = "SELECT * "
                    + "FROM Viaje v INNER JOIN Vuelo o ON v.vuelo=o.idVuelo "
                    + "INNER JOIN Avion a ON o.avion=a.id INNER JOIN TipoAvion t "
                    + "ON a.tipoAvion = t.idTipoAvion "
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
            v.setIdViaje(Integer.parseInt(rs.getString("idViaje")));
            v.setPrecio(Float.parseFloat(rs.getString("precio")));
            v.setDisponibles(Integer.parseInt(rs.getString("disponibles")));
            v.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
            // Vuelo
            aerolinea.logica.Vuelo o = new aerolinea.logica.Vuelo();
            o.setIdVuelo(rs.getString("idVuelo"));
            o.setDia(rs.getString("dia"));
            o.setHora(rs.getTime("hora"));
            // Origen
            o.setOrigen(this.origenVuelo(o.getIdVuelo()));
            // Destino
            o.setDestino(this.destinoVuelo(o.getIdVuelo()));
            //Avión
            aerolinea.logica.Avion a = new aerolinea.logica.Avion();
            a.setId(rs.getString("id"));
            //Tipoavion
            aerolinea.logica.Tipoavion t = new aerolinea.logica.Tipoavion();
            t.setIdTipoAvion(Integer.parseInt(rs.getString("idTipoAvion")));
            t.setMarca(rs.getString("marca"));
            t.setAnnio(rs.getInt("annio"));
            t.setModelo(rs.getString("modelo"));
            t.setCantidadPasajeros(rs.getInt("cantidadPasajeros"));
            t.setCantidadFilas(rs.getInt("cantidadFilas"));
            t.setAsientosPorFila(rs.getInt("asientosPorFila"));
            a.setTipoavion(t);
            v.setVuelo(o);

            return v;
        } catch (SQLException ex) {
            return null;
        }
    }

    private String sqlDatetimeFormat(java.util.Date fecha) {
        java.util.Date fechaHandler = fecha;
        java.text.SimpleDateFormat fechaFormat
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = fechaFormat.format(fechaHandler);
        return fechaFormat.format(fechaHandler);
    }

    private aerolinea.logica.Ciudad origenVuelo(String idVuelo) throws Throwable {
        String query = "SELECT * "
                + "FROM Vuelo v INNER JOIN Ciudad c ON v.origen=c.nombreCiudad "
                + "INNER JOIN Pais p ON c.abreviaturaPais=p.abreviatura "
                + "WHERE v.idVuelo='%s'";
        query = String.format(query, idVuelo);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            aerolinea.logica.Ciudad origen = new aerolinea.logica.Ciudad();
            origen.setNombre(rs.getString("nombreCiudad"));
            origen.setPais(new aerolinea.logica.Pais(rs.getString("abreviatura"), rs.getString("nombrePais")));
            return origen;
        } else {
            throw new Exception("El origen no existe");
        }
    }

    private aerolinea.logica.Ciudad destinoVuelo(String idVuelo) throws Throwable {
        String query = "SELECT * "
                + "FROM Vuelo v INNER JOIN Ciudad c ON v.destino=c.nombreCiudad "
                + "INNER JOIN Pais p ON c.abreviaturaPais=p.abreviatura "
                + "WHERE v.idVuelo='%s'";
        query = String.format(query, idVuelo);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            aerolinea.logica.Ciudad origen = new aerolinea.logica.Ciudad();
            origen.setNombre(rs.getString("nombreCiudad"));
            origen.setPais(new aerolinea.logica.Pais(rs.getString("abreviatura"), rs.getString("nombrePais")));
            return origen;
        } else {
            throw new Exception("El destino no existe");
        }
    }

    private String priceParam(float p) {
        return (p == 0 ? MAX : Integer.toString((int) p));
    }

    private String availableParam(int p) {
        return (p == 0 ? "" : Integer.toString(p));
    }

    private List<Reserva> getReserva(Viaje v) {
        List<Reserva> result = new ArrayList<Reserva>();
        String query = "SELECT * "
                + "FROM Viaje v INNER JOIN Reserva r ON r.viaje=v.idViaje "
                + "WHERE v.idViaje=%s";
        query = String.format(query, v.getIdViaje());
        System.out.println(query);
        ResultSet rs = db.executeQuery(query);
        try {

            while (rs.next()) {
                Reserva reserva = this.reservaInstance(rs);
                reserva.setFormapago(this.getFormaPago(reserva));
                reserva.setTiqueteList(this.getTiquete(reserva));
                reserva.setUsuario1(this.usuarioInstance(rs));
                result.add(reserva);
            }
        } catch (Throwable ex) {
            return null;
        }
        return result;
    }

    private Reserva reservaInstance(ResultSet rs) {
        Reserva r = new Reserva();
        try {
            r.setCantidad(rs.getInt("cantidad"));
            r.setDocumento(rs.getString("documento"));
            r.setIdReserva(rs.getInt("idReserva"));
        } catch (Throwable ex) {
            return null;
        }
        return r;
    }

    private List<Tiquete> getTiquete(Reserva r) {
        List<Tiquete> result = new ArrayList<Tiquete>();
        String query = "SELECT * FROM Reserva r INNER JOIN Tiquete t "
                + "ON t.reserva=r.idReserva WHERE r.idReserva=%s";
        query = String.format(query, r.getIdReserva());
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                Tiquete tiquete = this.TiqueteInstance(rs);
                tiquete.setReserva(r);
                result.add(tiquete);
            }
        } catch (Throwable ex) {
            return null;
        }
        return result;
    }

    private Tiquete TiqueteInstance(ResultSet rs) throws SQLException {
        Tiquete t = new Tiquete();
        t.setIdTiquete(rs.getInt("idTiquete"));
        t.setFila(rs.getString("fila"));
        t.setAsiento(rs.getInt("asiento"));
        return t;
    }
    private final String MAX = "999999";

    private Usuario usuarioInstance(ResultSet rs) {
        try {
            String query = "SELECT * FROM Usuario WHERE idUsuario=%s";
            query = String.format(query, rs.getInt("Usuario_idUsuario"));
            ResultSet rs2 = db.executeQuery(query);
            Usuario usuario = new Usuario();
            usuario.setEmail(rs2.getString("email"));
            usuario.setContrasenna(rs2.getString("contrasenna"));
            usuario.setNombre(rs2.getString("nombre"));
            usuario.setApellido(rs2.getString("apellido"));
            usuario.setFechaNacimiento(rs2.getString("fechaNacimiento"));
            usuario.setDireccion(rs2.getString("direccion"));
            usuario.setTelefonoTrabajo(rs2.getString("telefonoTrabajo"));
            usuario.setTelefono(rs2.getString("telefono"));
            usuario.setEsAdmin(rs2.getBoolean("esAdmin"));
            usuario.setIdUsuario(Integer.parseInt(rs2.getString("idUsuario")));
            return usuario;
        } catch (Throwable ex) {
            return null;
        }
    }

    private Formapago getFormaPago(Reserva reserva) {
        try {
            String query = "SELECT * FROM Reserva r INNER JOIN "
                    + "Formapago f ON r.formaPago=f.idFormaPago "
                    + "WHERE r.idReserva=%s";
            query = String.format(query, reserva.getIdReserva());
            ResultSet rs = this.db.executeQuery(query);
            Formapago f = new Formapago(
                    rs.getString("idFormaPago"),
                    rs.getString("nombreFormaPago"));
            return f;
        } catch (Throwable ex) {
            return null;
        }
    }

}
