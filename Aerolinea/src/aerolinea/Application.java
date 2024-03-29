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
        // Vuelo
        // Edición
        aerolinea.presentacion.vuelo.edicion.Model ModelVueloEdicion
                = new aerolinea.presentacion.vuelo.edicion.Model();
        aerolinea.presentacion.vuelo.edicion.View ViewVueloEdicion
                = new aerolinea.presentacion.vuelo.edicion.View();
        aerolinea.presentacion.vuelo.edicion.Controller ControllerVueloEdicion
                = new aerolinea.presentacion.vuelo.edicion.Controller(ModelVueloEdicion, ViewVueloEdicion);
        EDICION_VUELO_CONTROLLER = ControllerVueloEdicion;
        // Listado
        aerolinea.presentacion.vuelo.listado.Model ModelVueloListado
                = new aerolinea.presentacion.vuelo.listado.Model();
        aerolinea.presentacion.vuelo.listado.View ViewVueloListado
                = new aerolinea.presentacion.vuelo.listado.View();
        aerolinea.presentacion.vuelo.listado.Controller ControllerVueloListado
                = new aerolinea.presentacion.vuelo.listado.Controller(ModelVueloListado, ViewVueloListado);
        LISTADO_VUELO_CONTROLLER = ControllerVueloListado;
        // Viaje
        // Edición
        aerolinea.presentacion.viaje.edicion.Model ModelViajeEdicion
                = new aerolinea.presentacion.viaje.edicion.Model();
        aerolinea.presentacion.viaje.edicion.View ViewViajeEdicion
                = new aerolinea.presentacion.viaje.edicion.View();
        aerolinea.presentacion.viaje.edicion.Controller ControllerViajeEdicion
                = new aerolinea.presentacion.viaje.edicion.Controller(ModelViajeEdicion, ViewViajeEdicion);
        EDICION_VIAJE_CONTROLLER = ControllerViajeEdicion;
        // Listado
        aerolinea.presentacion.viaje.listado.Model ModelViajeListado
                = new aerolinea.presentacion.viaje.listado.Model();
        aerolinea.presentacion.viaje.listado.View ViewViajeListado
                = new aerolinea.presentacion.viaje.listado.View();
        aerolinea.presentacion.viaje.listado.Controller ControllerViajeListado
                = new aerolinea.presentacion.viaje.listado.Controller(ModelViajeListado, ViewViajeListado);
        LISTADO_VIAJE_CONTROLLER = ControllerViajeListado;

        // Login
        aerolinea.presentacion.usuario.login.Model ModelLogin
                = new aerolinea.presentacion.usuario.login.Model();
        aerolinea.presentacion.usuario.login.View ViewLogin
                = new aerolinea.presentacion.usuario.login.View();
        aerolinea.presentacion.usuario.login.Controller ControllerLogin
                = new aerolinea.presentacion.usuario.login.Controller(ModelLogin, ViewLogin);
        LOGIN_CONTROLLER = ControllerLogin;
        //Registro
        aerolinea.presentacion.usuario.registro.Model ModelRegistro
                = new aerolinea.presentacion.usuario.registro.Model();
        aerolinea.presentacion.usuario.registro.View ViewRegistro
                = new aerolinea.presentacion.usuario.registro.View();
        aerolinea.presentacion.usuario.registro.Controller ControllerRegistro
                = new aerolinea.presentacion.usuario.registro.Controller(ModelRegistro, ViewRegistro);
        REGISTRO_CONTROLLER = ControllerRegistro;

        //Búsqueda de vuelos
        aerolinea.presentacion.vuelo.publicGUI.Model ModelBusqueda
                = new aerolinea.presentacion.vuelo.publicGUI.Model();
        aerolinea.presentacion.vuelo.publicGUI.View ViewBusqueda
                = new aerolinea.presentacion.vuelo.publicGUI.View();
        aerolinea.presentacion.vuelo.publicGUI.Controller ControllerBusqueda
                = new aerolinea.presentacion.vuelo.publicGUI.Controller(ModelBusqueda, ViewBusqueda);

        BUSQUEDA_CONTROLLER = ControllerBusqueda;

        // Check-in        
        aerolinea.presentacion.check_in.Model ModelCheckIn
                = new aerolinea.presentacion.check_in.Model();
        aerolinea.presentacion.check_in.View ViewCheckIn
                = new aerolinea.presentacion.check_in.View();
        aerolinea.presentacion.check_in.Controller ControllerCheckIn
                = new aerolinea.presentacion.check_in.Controller(ModelCheckIn, ViewCheckIn);

        CHECK_IN_CONTROLLER = ControllerCheckIn;

        // Purchase
        aerolinea.presentacion.purchase.Model ModelPurchase
                = new aerolinea.presentacion.purchase.Model();
        aerolinea.presentacion.purchase.View ViewPurchase
                = new aerolinea.presentacion.purchase.View();
        aerolinea.presentacion.purchase.Controller ControllerPurchase
                = new aerolinea.presentacion.purchase.Controller(ModelPurchase, ViewPurchase);

        PURCHASE_CONTROLLER = ControllerPurchase;

        // User Info
        aerolinea.presentacion.usuario.information.Model ModelUserInfo
                = new aerolinea.presentacion.usuario.information.Model();
        aerolinea.presentacion.usuario.information.View ViewUserInfo
                = new aerolinea.presentacion.usuario.information.View();
        aerolinea.presentacion.usuario.information.Controller ControllerUserInfo
                = new aerolinea.presentacion.usuario.information.Controller(ModelUserInfo, ViewUserInfo);

        USUARIO_INFO_CONTROLLER = ControllerUserInfo;

        // User History
        aerolinea.presentacion.usuario.history.Model ModelUserHistory
                = new aerolinea.presentacion.usuario.history.Model();
        aerolinea.presentacion.usuario.history.View ViewUserHistory
                = new aerolinea.presentacion.usuario.history.View();
        aerolinea.presentacion.usuario.history.Controller ControllerUserHistory
                = new aerolinea.presentacion.usuario.history.Controller(ModelUserHistory, ViewUserHistory);

        USUARIO_HISTORY_CONTROLLER = ControllerUserHistory;
        // Application
        Model applicationModel = new Model();
        View applicationView = new View();
        Controller applicationController = new Controller(applicationModel, applicationView);
        APPLICATION_CONTROLLER = applicationController;

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
        applicationView.panel.add(ViewVueloEdicion);
        applicationView.panel.add(ViewVueloListado);
        applicationView.panel.add(ViewViajeEdicion);
        applicationView.panel.add(ViewViajeListado);
        applicationView.panel.add(ViewLogin);
        applicationView.panel.add(ViewRegistro);
        applicationView.panel.add(ViewBusqueda);
        applicationView.panel.add(ViewCheckIn);
        applicationView.panel.add(ViewPurchase);
        applicationView.panel.add(ViewUserInfo);
        applicationView.panel.add(ViewUserHistory);
    }

    public static Controller APPLICATION_CONTROLLER;

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

    public static aerolinea.presentacion.vuelo.edicion.Controller EDICION_VUELO_CONTROLLER;
    public static aerolinea.presentacion.vuelo.listado.Controller LISTADO_VUELO_CONTROLLER;

    public static aerolinea.presentacion.viaje.edicion.Controller EDICION_VIAJE_CONTROLLER;
    public static aerolinea.presentacion.viaje.listado.Controller LISTADO_VIAJE_CONTROLLER;

    public static aerolinea.presentacion.usuario.login.Controller LOGIN_CONTROLLER;

    public static aerolinea.presentacion.usuario.registro.Controller REGISTRO_CONTROLLER;

    public static aerolinea.presentacion.vuelo.publicGUI.Controller BUSQUEDA_CONTROLLER;

    public static aerolinea.presentacion.check_in.Controller CHECK_IN_CONTROLLER;

    public static aerolinea.presentacion.purchase.Controller PURCHASE_CONTROLLER;

    public static aerolinea.presentacion.usuario.information.Controller USUARIO_INFO_CONTROLLER;

    public static aerolinea.presentacion.usuario.history.Controller USUARIO_HISTORY_CONTROLLER;

}
