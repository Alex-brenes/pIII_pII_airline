/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.pais.listado;

import aerolinea.Application;

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

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    void buscar(String nombre) {
        try {
            model.setPaises(aerolinea.logica.Model.getInstance().searchPais(nombre));
        } catch (Throwable ex) {
        }
    }

    void editar(int row) {
        Application.EDICION_PAIS_CONTROLLER.consultar(model.getPaises().get(row).getAbreviatura());
    }

}
