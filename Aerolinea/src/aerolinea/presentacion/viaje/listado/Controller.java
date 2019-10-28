/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.viaje.listado;

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

    void buscar(Integer id) {
        try {
            model.setViajes(aerolinea.logica.Model.getInstance().searchViaje(id));
        } catch (Throwable ex) {
        }
    }

    void editar(int row) {
        Application.EDICION_VIAJE_CONTROLLER.consultar(model.getViajes().get(row).getIdViaje());
    }

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
}
