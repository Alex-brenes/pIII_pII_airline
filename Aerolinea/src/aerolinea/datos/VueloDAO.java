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
import aerolinea.logica.Ciudad;
import aerolinea.logica.Pais;
import aerolinea.logica.Tipoavion;
import aerolinea.logica.Vuelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VueloDAO extends AbstractDAO<Vuelo, String> {

    public VueloDAO() {
        super();
    }

    @Override
    public void add(Vuelo s) throws Throwable {
        String query = "INSERT INTO Vuelo (idVuelo, dia, hora, origen, destino, avion) "
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
                + "FROM Vuelo v INNER JOIN Avion a ON v.avion=a.id "
                + "INNER JOIN tipoavion t ON a.tipoAvion=t.idTipoAvion "
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
        String query = "UPDATE Vuelo SET dia='%s', hora='%s', origen='%s', destino='%s', avion='%s' "
                + "where idVuelo='%s'";
        // Actualiza la abreviatura del pais
        System.out.println(s.getHora().toString());
        query = String.format(query,
                s.getDia(),
                s.getHora().toString(),
                s.getOrigen().getNombre(),
                s.getDestino().getNombre(),
                s.getAvion().getId(),
                s.getIdVuelo());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El vuelo no existe");
        }
    }

    @Override
    public List<Vuelo> searh(String s) throws Throwable {
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String query = "SELECT * "
                    + "FROM Vuelo v INNER JOIN Avion a ON v.avion=a.id "
                    + "INNER JOIN tipoavion t ON a.tipoAvion=t.idTipoAvion "
                    + "WHERE v.idVuelo LIKE '%%%s%%'";
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
    public List<Vuelo> search() throws Throwable {
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String query = "SELECT * "
                    + "FROM Vuelo v INNER JOIN Avion a ON v.avion=a.id "
                    + "INNER JOIN tipoavion t ON a.tipoAvion=t.idTipoAvion ";
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
            Vuelo v = new Vuelo();
            v.setIdVuelo(rs.getString("idVuelo"));
            v.setDia(rs.getString("dia"));
            v.setHora(rs.getTime("hora"));
            // Origen
            v.setOrigen(this.origenVuelo(v.getIdVuelo()));
            // Destino
            v.setDestino(this.destinoVuelo(v.getIdVuelo()));
            // Avión
            Avion a = new Avion();
            a.setId(rs.getString("id"));
            // Tipo avión
            Tipoavion t = new Tipoavion();
            t.setIdTipoAvion(Integer.parseInt(rs.getString("idTipoAvion")));
            t.setMarca(rs.getString("marca"));
            t.setAnnio(rs.getInt("annio"));
            t.setModelo(rs.getString("modelo"));
            t.setCantidadPasajeros(rs.getInt("cantidadPasajeros"));
            t.setCantidadFilas(rs.getInt("cantidadFilas"));
            t.setAsientosPorFila(rs.getInt("asientosPorFila"));
            a.setTipoavion(t);
            v.setAvion(a);
            return v;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Ciudad origenVuelo(String idVuelo) throws Throwable {
        String query = "SELECT * "
                + "FROM Vuelo v INNER JOIN Ciudad c ON v.origen=c.nombreCiudad "
                + "INNER JOIN Pais p ON c.abreviaturaPais=p.abreviatura "
                + "WHERE v.idVuelo='%s'";
        query = String.format(query, idVuelo);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            Ciudad origen = new Ciudad();
            origen.setNombre(rs.getString("nombreCiudad"));
            origen.setPais(new Pais(rs.getString("abreviatura"), rs.getString("nombrePais")));
            return origen;
        } else {
            throw new Exception("El origen no existe");
        }
    }

    private Ciudad destinoVuelo(String idVuelo) throws Throwable {
        String query = "SELECT * "
                + "FROM Vuelo v INNER JOIN Ciudad c ON v.destino=c.nombreCiudad "
                + "INNER JOIN Pais p ON c.abreviaturaPais=p.abreviatura "
                + "WHERE v.idVuelo='%s'";
        query = String.format(query, idVuelo);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            Ciudad origen = new Ciudad();
            origen.setNombre(rs.getString("nombreCiudad"));
            origen.setPais(new Pais(rs.getString("abreviatura"), rs.getString("nombrePais")));
            return origen;
        } else {
            throw new Exception("El destino no existe");
        }
    }

    @Override
    public Time dateSQLWrapper(Date date) {
        return new Time(date.getHours(), date.getMinutes(), date.getSeconds());
    }

}
