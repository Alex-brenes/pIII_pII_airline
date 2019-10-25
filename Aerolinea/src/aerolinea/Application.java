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
            // Edición
            aerolinea.presentacion.flota.tipoAvion.edicion.Model ModelFlotaEdicion = 
                    new aerolinea.presentacion.flota.tipoAvion.edicion.Model();
            aerolinea.presentacion.flota.tipoAvion.edicion.View ViewFlotaEdicion = 
                    new aerolinea.presentacion.flota.tipoAvion.edicion.View();
            aerolinea.presentacion.flota.tipoAvion.edicion.Controller ControllerFlotaEdicion = 
                    new aerolinea.presentacion.flota.tipoAvion.edicion.Controller
                        (ModelFlotaEdicion, ViewFlotaEdicion);
            EDICION_FLOTA_CONTROLLER = ControllerFlotaEdicion;
            // Listado
            aerolinea.presentacion.flota.tipoAvion.listado.Model ModelFlotaListado =
                    new aerolinea.presentacion.flota.tipoAvion.listado.Model();
            aerolinea.presentacion.flota.tipoAvion.listado.View ViewFlotaListado =
                    new aerolinea.presentacion.flota.tipoAvion.listado.View();
            aerolinea.presentacion.flota.tipoAvion.listado.Controller ControllerFlotaListado =
                    new aerolinea.presentacion.flota.tipoAvion.listado.Controller
                        (ModelFlotaListado,ViewFlotaListado);
            LISTADO_FLOTA_CONTROLLER = ControllerFlotaListado;

        // Application
        Model applicationModel = new Model();
        View applicationView = new View();
        Controller applicationController = new Controller(applicationModel, applicationView);
        
        applicationView.setVisible(true);
        
        //jInternalFrames
        applicationView.panel.add(ViewFlotaEdicion);
        applicationView.panel.add(ViewFlotaListado);
        
    }
    
    public static aerolinea.presentacion.flota.tipoAvion.edicion.Controller 
            EDICION_FLOTA_CONTROLLER;
    public static aerolinea.presentacion.flota.tipoAvion.listado.Controller 
            LISTADO_FLOTA_CONTROLLER;
    
}
