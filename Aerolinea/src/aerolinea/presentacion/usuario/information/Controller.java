/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.information;

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
    
    public void Show(){
        view.setVisible(true);
    }
    
    public void Hide(){
        view.setVisible(false);
    }

    public void setUser(Usuario user) {
        model.setUsuario(user);
    }

    void update(Usuario u) {
        try{
            aerolinea.logica.Model.getInstance().updateUsuario(u);
            this.model.setUsuario(u);
            Application.APPLICATION_CONTROLLER.setUser(u);
        }
        catch(Throwable ex){
            
        }
    }

    void historial() {
        Application.USUARIO_HISTORY_CONTROLLER.Show(model.getUsuario());
    }

    
}
