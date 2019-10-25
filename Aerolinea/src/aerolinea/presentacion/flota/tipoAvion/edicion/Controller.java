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
package aerolinea.presentacion.flota.tipoAvion.edicion;

import aerolinea.logica.Tipoavion;

/**
 *
 * @author pc
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);
        this.view.setController(this);
    }

    public void consultar(String id) {
        try {
            model.setTipoAvion(aerolinea.logica.Model.getInstance().getTipoAvion(id));
        } catch (Throwable ex) {
            model.setTipoAvion(new Tipoavion("El avión no existe"));
        }
    }

    public void modificar(Tipoavion a) {
        try {
            aerolinea.logica.Model.getInstance().updateTipoavion(a);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void agregar(Tipoavion a) {
        try {
            aerolinea.logica.Model.getInstance().addTipoAvion(a);
            this.model.setTipoAvion(new Tipoavion());
        } catch (Throwable ex) {
        }
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

}
