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
            Application.EDICION_FLOTA_CONTROLLER.show();
        }
        // Listado

        public void ListadoTipoShow() {
            Application.LISTADO_FLOTA_CONTROLLER.show();
        }

    public void vueloShow() {

    }

    public void informacionUsuarioShow() {

    }

    public void informacionAerolineaShow() {

    }

}
