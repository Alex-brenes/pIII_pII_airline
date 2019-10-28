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
package aerolinea.logica;

import aerolinea.datos.AvionDAO;
import aerolinea.datos.UsuarioDAO;
import aerolinea.datos.CiudadDAO;
import aerolinea.datos.FormaPagoDAO;
import aerolinea.datos.PaisDAO;
import aerolinea.datos.ReservaDAO;
import aerolinea.datos.TiqueteDAO;
import aerolinea.datos.TipoAvionDAO;
import aerolinea.datos.VueloDAO;
import aerolinea.datos.ViajeDAO;
import java.util.List;

/**
 *
 * @author pc
 */
public class Model {

    AvionDAO avionDAO;
    UsuarioDAO usuarioDAO;
    CiudadDAO ciudadDAO;
    FormaPagoDAO formaPagoDAO;
    PaisDAO paisDAO;
    ReservaDAO reservaDAO;
    TiqueteDAO tiqueteDAO;
    TipoAvionDAO tipoAvionDAO;
    VueloDAO vueloDAO;
    ViajeDAO viajeDAO;

    public Model() {
        this.avionDAO = new AvionDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.ciudadDAO = new CiudadDAO();
        this.formaPagoDAO = new FormaPagoDAO();
        this.paisDAO = new PaisDAO();
        this.reservaDAO = new ReservaDAO();
        this.tiqueteDAO = new TiqueteDAO();
        this.tipoAvionDAO = new TipoAvionDAO();
        this.vueloDAO = new VueloDAO();
        this.viajeDAO = new ViajeDAO();
    }

    private static Model instance;

    // Avión
    public void addAvion(Avion a) throws Throwable {
        this.avionDAO.add(a);
    }

    public List<Avion> searchAvion(String id) throws Throwable {
        return this.avionDAO.searh(id);
    }

    public void updateAvion(Avion a) throws Throwable {
        this.avionDAO.update(a);
    }

    public Avion getAvion(String s) throws Throwable {
        return this.avionDAO.get(s);
    }
    
    public List<Avion> searchAvion() throws Throwable {
        return this.avionDAO.search();
    }

    // Usuario
    public void addUsuario(Usuario u) throws Throwable {
        this.usuarioDAO.add(u);
    }

    public List<Usuario> searchUsuario(Integer id) throws Throwable {
        return this.usuarioDAO.searh(id);
    }

    public void updateUsuario(Usuario a) throws Throwable {
        this.usuarioDAO.update(a);
    }

    public Usuario getUsuario(Integer s) throws Throwable {
        return this.usuarioDAO.get(s);
    }

    // Ciudad
    public void addCiudad(Ciudad c) throws Throwable {
        this.ciudadDAO.add(c);
    }

    public List<Ciudad> searchCiudad(String id) throws Throwable {
        return this.ciudadDAO.searh(id);
    }

    public void updateCiudad(Ciudad c) throws Throwable {
        this.ciudadDAO.update(c);
    }

    public Ciudad getCiudad(String s) throws Throwable {
        return this.ciudadDAO.get(s);
    }
    
    public List<Ciudad> searchCiudad() throws Throwable{
        return this.ciudadDAO.search();
    }

    // formaPago
    public void addFormaPago(Formapago f) throws Throwable {
        this.formaPagoDAO.add(f);
    }

    public List<Formapago> searchFormaPago(String id) throws Throwable {
        return this.formaPagoDAO.searh(id);
    }

    public void updateFormaPago(Formapago f) throws Throwable {
        this.formaPagoDAO.update(f);
    }

    public Formapago getFormaPago(String s) throws Throwable {
        return this.formaPagoDAO.get(s);
    }

    // Pais
    public void addPais(Pais p) throws Throwable {
        this.paisDAO.add(p);
    }

    public List<Pais> searchPais(String id) throws Throwable {
        return this.paisDAO.searh(id);
    }

    public void updatePais(Pais a) throws Throwable {
        this.paisDAO.update(a);
    }

    public Pais getPais(String s) throws Throwable {
        return this.paisDAO.get(s);
    }

    public List<Pais> searchPais() throws Throwable {
        return this.paisDAO.search();
    }

    // Reserva
    public void addReserva(Reserva p) throws Throwable {
        this.reservaDAO.add(p);
    }

    public List<Reserva> searchReserva(Integer id) throws Throwable {
        return this.reservaDAO.searh(id);
    }

    public void updateReserva(Reserva r) throws Throwable {
        this.reservaDAO.update(r);
    }

    public Reserva getReserva(Integer s) throws Throwable {
        return this.reservaDAO.get(s);
    }

    // Tiquete
    public void addTiquete(Tiquete t) throws Throwable {
        this.tiqueteDAO.add(t);
    }

    public List<Tiquete> searchTiquete(Integer id) throws Throwable {
        return this.tiqueteDAO.searh(id);
    }

    public void updateTiquete(Tiquete t) throws Throwable {
        this.tiqueteDAO.update(t);
    }

    public Tiquete getTiquete(Integer s) throws Throwable {
        return this.tiqueteDAO.get(s);
    }

    // TipoAvion
    public void addTipoAvion(Tipoavion t) throws Throwable {
        this.tipoAvionDAO.add(t);
    }

    public List<Tipoavion> searchTipoAvion(String id) throws Throwable {
        return this.tipoAvionDAO.searh(id);
    }

    public void updateTipoavion(Tipoavion t) throws Throwable {
        this.tipoAvionDAO.update(t);
    }

    public Tipoavion getTipoAvion(String s) throws Throwable {
        return this.tipoAvionDAO.get(s);
    }

    public List<Tipoavion> searchTipoAvion() throws Throwable {
        return this.tipoAvionDAO.search();
    }

    // Vuelo
    public void addVuelo(Vuelo t) throws Throwable {
        this.vueloDAO.add(t);
    }

    public List<Vuelo> searchVuelo(String id) throws Throwable {
        return this.vueloDAO.searh(id);
    }

    public void updateVuelo(Vuelo t) throws Throwable {
        this.vueloDAO.update(t);
    }

    public Vuelo getVuelo(String s) throws Throwable {
        return this.vueloDAO.get(s);
    }
    
    public void deleteVuelo(Vuelo v) throws Throwable {
        this.vueloDAO.delete(v);
    } 
    
    public List<Vuelo> searchVuelo() throws Throwable{
        return this.vueloDAO.search();
    }

    // Viaje
    public void addViaje(Viaje t) throws Throwable {
        this.viajeDAO.add(t);
    }

    public List<Viaje> searchViaje(Integer id) throws Throwable {
        return this.viajeDAO.searh(id);
    }

    public void updateViaje(Viaje t) throws Throwable {
        this.viajeDAO.update(t);
    }

    public Viaje getViaje(Integer s) throws Throwable {
        return this.viajeDAO.get(s);
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

}
