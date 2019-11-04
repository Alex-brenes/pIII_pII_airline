/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.history;

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

    public void Show(Usuario u) {
        this.model.setUser(u);
        cargarReservas();
        this.view.setVisible(true);
    }

    public void Hide() {
        this.view.setVisible(false);
    }

    private void cargarReservas() {
        try {
            model.setReservas(aerolinea.logica.Model.getInstance().searchReserva(model.getUser()));
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

}
