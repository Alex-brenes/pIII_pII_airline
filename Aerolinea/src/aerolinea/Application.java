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
package aerolinea;

import aerolinea.presentacion.application.*;

/**
 *
 * @author pc
 */
public class Application {

    public static void main(String[] args) {
        // Flota
        // Tipos de avión
        // Edición
        aerolinea.presentacion.flota.tipoAvion.edicion.Model ModelTipoAvionEdicion
                = new aerolinea.presentacion.flota.tipoAvion.edicion.Model();
        aerolinea.presentacion.flota.tipoAvion.edicion.View ViewTipoAvionEdicion
                = new aerolinea.presentacion.flota.tipoAvion.edicion.View();
        aerolinea.presentacion.flota.tipoAvion.edicion.Controller ControllerTipoAvionEdicion
                = new aerolinea.presentacion.flota.tipoAvion.edicion.Controller(ModelTipoAvionEdicion, ViewTipoAvionEdicion);
        EDICION_TIPO_AVION_CONTROLLER = ControllerTipoAvionEdicion;
        // Listado
        aerolinea.presentacion.flota.tipoAvion.listado.Model ModelTipoAvionListado
                = new aerolinea.presentacion.flota.tipoAvion.listado.Model();
        aerolinea.presentacion.flota.tipoAvion.listado.View ViewTipoAvionListado
                = new aerolinea.presentacion.flota.tipoAvion.listado.View();
        aerolinea.presentacion.flota.tipoAvion.listado.Controller ControllerTipoAvionListado
                = new aerolinea.presentacion.flota.tipoAvion.listado.Controller(ModelTipoAvionListado, ViewTipoAvionListado);
        LISTADO_TIPO_AVION_CONTROLLER = ControllerTipoAvionListado;
        // Avión
        // Edición
        aerolinea.presentacion.flota.avion.edicion.Model ModelAvionEdicion
                = new aerolinea.presentacion.flota.avion.edicion.Model();
        aerolinea.presentacion.flota.avion.edicion.View ViewAvionEdicion
                = new aerolinea.presentacion.flota.avion.edicion.View();
        aerolinea.presentacion.flota.avion.edicion.Controller ControllerAvionEdicion
                = new aerolinea.presentacion.flota.avion.edicion.Controller(ModelAvionEdicion, ViewAvionEdicion);
        EDICION_AVION_CONTROLLER = ControllerAvionEdicion;
        // Listado
        aerolinea.presentacion.flota.avion.listado.Model ModelAvionListado
                = new aerolinea.presentacion.flota.avion.listado.Model();
        aerolinea.presentacion.flota.avion.listado.View ViewAvionListado
                = new aerolinea.presentacion.flota.avion.listado.View();
        aerolinea.presentacion.flota.avion.listado.Controller ControllerAvionListado
                = new aerolinea.presentacion.flota.avion.listado.Controller(ModelAvionListado, ViewAvionListado);
        LISTADO_AVION_CONTROLLER = ControllerAvionListado;
        // Aeropuertos
        // País
        // Agregar
        aerolinea.presentacion.aeropuertos.pais.edicion.Model ModelPaisEdicion
                = new aerolinea.presentacion.aeropuertos.pais.edicion.Model();
        aerolinea.presentacion.aeropuertos.pais.edicion.View ViewPaisEdicion
                = new aerolinea.presentacion.aeropuertos.pais.edicion.View();
        aerolinea.presentacion.aeropuertos.pais.edicion.Controller ControllerPaisEdicion
                = new aerolinea.presentacion.aeropuertos.pais.edicion.Controller(ModelPaisEdicion, ViewPaisEdicion);
        EDICION_PAIS_CONTROLLER = ControllerPaisEdicion;
        // Listado
        aerolinea.presentacion.aeropuertos.pais.listado.Model ModelPaisListado
                = new aerolinea.presentacion.aeropuertos.pais.listado.Model();
        aerolinea.presentacion.aeropuertos.pais.listado.View ViewPaisListado
                = new aerolinea.presentacion.aeropuertos.pais.listado.View();
        aerolinea.presentacion.aeropuertos.pais.listado.Controller ControllerPaisListado
                = new aerolinea.presentacion.aeropuertos.pais.listado.Controller(ModelPaisListado, ViewPaisListado);
        LISTADO_PAIS_CONTROLLER = ControllerPaisListado;
        // Ciudad
        // Edición
        aerolinea.presentacion.aeropuertos.ciudad.edicion.Model ModelCiudadEdicion
                = new aerolinea.presentacion.aeropuertos.ciudad.edicion.Model();
        aerolinea.presentacion.aeropuertos.ciudad.edicion.View ViewCiudadEdicion
                = new aerolinea.presentacion.aeropuertos.ciudad.edicion.View();
        aerolinea.presentacion.aeropuertos.ciudad.edicion.Controller ControllerCiudadEdicion
                = new aerolinea.presentacion.aeropuertos.ciudad.edicion.Controller(ModelCiudadEdicion, ViewCiudadEdicion);
        EDICION_CIUDAD_CONTROLLER = ControllerCiudadEdicion;
        // Listado
        aerolinea.presentacion.aeropuertos.ciudad.listado.Model ModelCiudadListado
                = new aerolinea.presentacion.aeropuertos.ciudad.listado.Model();
        aerolinea.presentacion.aeropuertos.ciudad.listado.View ViewCiudadListado
                = new aerolinea.presentacion.aeropuertos.ciudad.listado.View();
        aerolinea.presentacion.aeropuertos.ciudad.listado.Controller ControllerCiudadListado
                = new aerolinea.presentacion.aeropuertos.ciudad.listado.Controller(ModelCiudadListado, ViewCiudadListado);
        LISTADO_CIUDAD_CONTROLLER = ControllerCiudadListado;
        // Forma de pago
        // Edición
        aerolinea.presentacion.formaPago.edicion.Model ModelFormaPagoEdicion
                = new aerolinea.presentacion.formaPago.edicion.Model();
        aerolinea.presentacion.formaPago.edicion.View ViewFormaPagoEdicion
                = new aerolinea.presentacion.formaPago.edicion.View();
        aerolinea.presentacion.formaPago.edicion.Controller ControllerFormaPagoEdicion
                = new aerolinea.presentacion.formaPago.edicion.Controller(ModelFormaPagoEdicion, ViewFormaPagoEdicion);
        EDICION_FORMA_PAGO_CONTROLLER = ControllerFormaPagoEdicion;
        // Listado
        aerolinea.presentacion.formaPago.listado.Model ModelFormaPagoListado
                = new aerolinea.presentacion.formaPago.listado.Model();
        aerolinea.presentacion.formaPago.listado.View ViewFormaPagoListado
                = new aerolinea.presentacion.formaPago.listado.View();
        aerolinea.presentacion.formaPago.listado.Controller ControllerFormaPagoListado
                = new aerolinea.presentacion.formaPago.listado.Controller(ModelFormaPagoListado, ViewFormaPagoListado);
        LISTADO_FORMA_PAGO_CONTROLLER = ControllerFormaPagoListado;
        // Application
        Model applicationModel = new Model();
        View applicationView = new View();
        Controller applicationController = new Controller(applicationModel, applicationView);

        applicationView.setVisible(true);

        //jInternalFrames
        applicationView.panel.add(ViewTipoAvionEdicion);
        applicationView.panel.add(ViewTipoAvionListado);
        applicationView.panel.add(ViewAvionEdicion);
        applicationView.panel.add(ViewAvionListado);
        applicationView.panel.add(ViewPaisEdicion);
        applicationView.panel.add(ViewPaisListado);
        applicationView.panel.add(ViewCiudadEdicion);
        applicationView.panel.add(ViewCiudadListado);
        applicationView.panel.add(ViewFormaPagoEdicion);
        applicationView.panel.add(ViewFormaPagoListado);
    }

    public static aerolinea.presentacion.flota.tipoAvion.edicion.Controller EDICION_TIPO_AVION_CONTROLLER;
    public static aerolinea.presentacion.flota.tipoAvion.listado.Controller LISTADO_TIPO_AVION_CONTROLLER;

    public static aerolinea.presentacion.flota.avion.edicion.Controller EDICION_AVION_CONTROLLER;
    public static aerolinea.presentacion.flota.avion.listado.Controller LISTADO_AVION_CONTROLLER;

    public static aerolinea.presentacion.aeropuertos.pais.edicion.Controller EDICION_PAIS_CONTROLLER;
    public static aerolinea.presentacion.aeropuertos.pais.listado.Controller LISTADO_PAIS_CONTROLLER;

    public static aerolinea.presentacion.aeropuertos.ciudad.edicion.Controller EDICION_CIUDAD_CONTROLLER;
    public static aerolinea.presentacion.aeropuertos.ciudad.listado.Controller LISTADO_CIUDAD_CONTROLLER;

    public static aerolinea.presentacion.formaPago.edicion.Controller EDICION_FORMA_PAGO_CONTROLLER;
    public static aerolinea.presentacion.formaPago.listado.Controller LISTADO_FORMA_PAGO_CONTROLLER;

}
