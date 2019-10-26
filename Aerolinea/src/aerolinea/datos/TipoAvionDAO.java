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

import aerolinea.logica.Tipoavion;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class TipoAvionDAO extends AbstractDAO<Tipoavion, String> {

    public TipoAvionDAO() {
        super();
    }

    @Override
    public void add(Tipoavion s) throws Throwable {
        String query = "INSERT INTO TipoAvion (idTipoAvion, marca, annio, modelo, cantidadPasajeros, cantidadFilas, asientosPorFila) "
                + "values('%s','%s',%s,'%s', %s, %s, %s)";
        query = String.format(query,
                s.getIdTipoAvion(),
                s.getMarca(),
                s.getAnnio(),
                s.getModelo(),
                s.getCantidadPasajeros(),
                s.getCantidadFilas(),
                s.getAsientosPorFila());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El tipo de avion ya existe");
        }
    }

    @Override
    public void delete(Tipoavion s) throws Throwable {
        String query = "DELETE FROM TipoAvion where id='%s'";
        query = String.format(query, s.getIdTipoAvion());
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El tipo de avion no existe");
        }
    }

    @Override
    public Tipoavion get(String id) throws Throwable {
        String query = "SELECT * "
                + "FROM TipoAvion s "
                + "where s.idTipoAvion='%s'";
        query = String.format(query, id);
        ResultSet rs = db.executeQuery(query);
        if (rs.next()) {
            return this.instancia(rs);
        } else {
            throw new Exception("El tipo de avión no Existe");
        }
    }

    @Override
    public void update(Tipoavion t) throws Throwable {
        String query = "UPDATE TipoAvion SET marca='%s',"
                + "annio=%s, modelo = '%s', cantidadPasajeros = %s, "
                + "cantidadFilas = %s, asientosPorFila = %s "
                + "where idTipoAvion='%s'";
        query = String.format(query,
                t.getMarca(),
                t.getAnnio(),
                t.getModelo(),
                t.getCantidadPasajeros(),
                t.getCantidadFilas(),
                t.getAsientosPorFila(),
                t.getIdTipoAvion());
        System.out.println(query);
        int count = db.executeUpdate(query);
        if (count == 0) {
            throw new Exception("El tipo de avión no existe");
        }
    }

    @Override
    public List<Tipoavion> searh(String id) throws Throwable { // Búsqueda por id
        List<Tipoavion> resultado = new ArrayList<Tipoavion>();
        try {
            String query = "SELECT * "
                    + "FROM TipoAvion t "
                    + "WHERE t.idTipoAvion LIKE '%%%s%%'";
            query = String.format(query, id);
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    // Returns a 'TipoAvion' new reference.
    @Override
    public Tipoavion instancia(ResultSet rs) {
        try {
            String s;
            Tipoavion t = new Tipoavion();
            t.setIdTipoAvion(rs.getString("idTipoAvion"));
            t.setMarca(rs.getString("marca"));
            t.setAnnio(Integer.parseInt(rs.getString("annio")));
            t.setModelo(rs.getString("modelo"));
            t.setCantidadPasajeros(Integer.parseInt(rs.getString("cantidadPasajeros")));
            t.setCantidadFilas(Integer.parseInt(rs.getString("cantidadFilas")));
            t.setAsientosPorFila(Integer.parseInt(rs.getString("asientosPorFila")));
            return t;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Tipoavion> searh() throws Throwable {
        List<Tipoavion> resultado = new ArrayList<>();
        try {
            String query = "SELECT * FROM TipoAvion";
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                resultado.add(this.instancia(rs));
            }
        } catch (Throwable ex) {
        }
        return resultado;
    }

}
