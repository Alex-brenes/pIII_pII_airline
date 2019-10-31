/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.login;

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
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    Usuario login(Usuario toUser) {
        try {
            if (Application.APPLICATION_CONTROLLER.getModel().getUser().getEmail().isEmpty()) {

            }
            Usuario user = aerolinea.logica.Model.getInstance().getUsuario(toUser.getEmail());
            if (0 != user.getContrasenna().compareTo(toUser.getContrasenna())) {
                throw new Exception("Wrong password");
            }
            this.hide();
            Application.APPLICATION_CONTROLLER.login(user);
            return user;
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        return new Usuario();

    }

    void registerUser() {
        try {
            if (Application.APPLICATION_CONTROLLER.getModel().getUser().getEmail().isEmpty()) {
                this.hide();
                Application.REGISTRO_CONTROLLER.show();
            }
            throw new Exception("");
        }
        catch(Throwable ex){}
    }

}
