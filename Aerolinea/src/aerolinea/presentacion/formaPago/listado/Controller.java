/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.formaPago.listado;

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

    void buscar(String id) {
        try {
            model.setFormasPago(aerolinea.logica.Model.getInstance().searchFormaPago(id));
        } catch (Throwable ex) {
        }
    }

    void editar(int row) {
        Application.EDICION_FORMA_PAGO_CONTROLLER.consultar(model.getFormasPago().get(row).getIdFormaPago());
    }
}
