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

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);
        this.view.setController(this);
    }
    //Flota
    // Edicion
    public void EdicionTipoShow() {
        Application.EDICION_TIPO_AVION_CONTROLLER.show();
    }
    // Listado

    public void ListadoTipoShow() {
        Application.LISTADO_TIPO_AVION_CONTROLLER.show();
    }

    public void EdicionAvionShow() {
        Application.EDICION_AVION_CONTROLLER.show();
    }
    // Listado

    public void ListadoAvionShow() {
        Application.LISTADO_AVION_CONTROLLER.show();
    }

    // Aeropuertos
    // País
        // Edicion
        
        public void EdicionPaisShow() {
            Application.EDICION_PAIS_CONTROLLER.show();
        }
        // Listado
        public void ListadoPaisShow() {
            Application.LISTADO_PAIS_CONTROLLER.show();
        }
        
    // Ciudad
        public void EdicionCiudadShow() {
            Application.EDICION_CIUDAD_CONTROLLER.show();
        }
        public void ListadoCiudadShow() {
            Application.LISTADO_CIUDAD_CONTROLLER.show();
        }
    // Forma de pago
        public void EdicionFormaPagoShow(){
            Application.EDICION_FORMA_PAGO_CONTROLLER.show();
        }
        public void ListadoFormaPagoShow() {
            Application.LISTADO_FORMA_PAGO_CONTROLLER.show();
        }
    // Vuelo
        void EdicionVueloShow() {
            Application.EDICION_VUELO_CONTROLLER.show();
        }
        void ListadoVueloShow() {
            Application.LISTADO_VUELO_CONTROLLER.show();
        }
    // Viaje
        void EdicionViajeShow() {
            Application.EDICION_VIAJE_CONTROLLER.show();
        }

        void ListadoViajeShow() {
            Application.LISTADO_VIAJE_CONTROLLER.show();
        }
    // Login
        void LoginShow() {
            Application.LOGIN_CONTROLLER.show();
        }
        
    // Registro
        void RegistroLogin(){
            Application.REGISTRO_CONTROLLER.show();
        }

    public void login(Usuario user) {
        this.model.setUser(user);
    }

    void logout() {
        this.model.setUser(new Usuario());
    }
        
}
