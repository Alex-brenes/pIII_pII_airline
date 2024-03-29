/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.registro;

import aerolinea.Application;
import aerolinea.logica.Usuario;

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

    public void show() {
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    void registerUser(Usuario toUser) {
        try {
            aerolinea.logica.Model.getInstance().addUsuario(toUser);
            Application.APPLICATION_CONTROLLER.login(toUser);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

}
