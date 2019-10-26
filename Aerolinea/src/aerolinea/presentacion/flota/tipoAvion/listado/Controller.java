/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.flota.tipoAvion.listado;

import aerolinea.Application;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);
        this.view.setController(this);
    }

    public void buscar(String id) {
        try {
            model.setTiposAviones(aerolinea.logica.Model.getInstance().searchTipoAvion(id));
        } catch (Throwable ex) {
        }
    }

    public void editar(int row) {
        Application.EDICION_AVION_CONTROLLER.consultar(model.getTiposAviones().get(row).getIdTipoAvion());
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

}
