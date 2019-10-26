/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.flota.avion.edicion;

import aerolinea.logica.Avion;
import aerolinea.logica.Tipoavion;
import java.util.List;

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
        this.recuperarTodos();
        this.model.getAvion().setTipoavion(this.model.getTiposAviones().get(0));
        this.model.notifyObservers();
    }

    public void recuperarTodos() {
        try {
            this.model.setTiposAviones(aerolinea.logica.Model.getInstance().searchTipoAvion());
        } catch (Throwable ex) {
        }
    }

    public void consultar(String id) {
        try {
            model.setAvion(aerolinea.logica.Model.getInstance().getAvion(id));
        } catch (Throwable ex) {
            Avion a = new Avion("El avión no existe");
            a.setTipoavion(this.model.getTiposAviones().get(0));
            this.model.setAvion(a);
        }
    }

    public void modificar(Avion a) {
        try {
            aerolinea.logica.Model.getInstance().updateAvion(a);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void agregar(Avion a) {
        try {
            aerolinea.logica.Model.getInstance().addAvion(a);
            this.model.setAvion(new Avion());
            this.model.getAvion().setTipoavion(this.model.getTiposAviones().get(0));
        } catch (Throwable ex) {
        }
    }

    public void show() {
        this.recuperarTodos();
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

}
