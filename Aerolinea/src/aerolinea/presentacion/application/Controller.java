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
package aerolinea.presentacion.application;

import aerolinea.Application;
import aerolinea.logica.Usuario;

/**
 *
 * @author pc
 */
public class Controller {

    private Model model;
    private View view;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);
        this.view.setController(this);
    }

    //Flota
    // Edicion
    public void EdicionTipoShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_TIPO_AVION_CONTROLLER.show();
        }
    }
    // Listado

    public void ListadoTipoShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_TIPO_AVION_CONTROLLER.show();
        }
    }

    public void EdicionAvionShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_AVION_CONTROLLER.show();
        }
    }
    // Listado

    public void ListadoAvionShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_AVION_CONTROLLER.show();
        }
    }

    // Aeropuertos
    // País
    // Edicion
    public void EdicionPaisShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_PAIS_CONTROLLER.show();
        }
    }
    // Listado

    public void ListadoPaisShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_PAIS_CONTROLLER.show();
        }
    }

    // Ciudad
    public void EdicionCiudadShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_CIUDAD_CONTROLLER.show();
        }
    }

    public void ListadoCiudadShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_CIUDAD_CONTROLLER.show();
        }
    }

    // Forma de pago
    public void EdicionFormaPagoShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_FORMA_PAGO_CONTROLLER.show();
        }
    }

    public void ListadoFormaPagoShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_FORMA_PAGO_CONTROLLER.show();
        }
    }

    // Vuelo
    void EdicionVueloShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_VUELO_CONTROLLER.show();
        }
    }

    void ListadoVueloShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_VUELO_CONTROLLER.show();
        }
    }

    // Viaje
    void EdicionViajeShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.EDICION_VIAJE_CONTROLLER.show();
        }
    }

    void ListadoViajeShow() {
        if (this.model.getUser().getEsAdmin()) {
            Application.LISTADO_VIAJE_CONTROLLER.show();
        }
    }

    // Login
    void LoginShow() {
        Application.LOGIN_CONTROLLER.show();
    }

    // Registro
    void RegistroLogin() {
        Application.REGISTRO_CONTROLLER.show();
    }

    public void login(Usuario user) {
        this.model.setUser(user);
    }

    void logout() {
        this.model.setUser(new Usuario());
    }

    // Búsqueda de vuelos
    void BusquedaVuelosShow() {
        Application.BUSQUEDA_CONTROLLER.show();
    }

}
