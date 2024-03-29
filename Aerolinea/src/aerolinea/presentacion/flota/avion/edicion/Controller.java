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
        this.iniciar();

    }

    public void iniciar() {
        try {
            this.model.setTiposAviones(aerolinea.logica.Model.getInstance().searchTipoAvion());
        } catch (Throwable ex) {
        }
        List<Tipoavion> aux = this.model.getTiposAviones();
        if (aux.size() > 0) {
            this.model.getAvion().setTipoavion(this.model.getTiposAviones().get(0));
        }
        this.model.setChanged();
        this.model.notifyObservers();
    }

    public void consultar(String id) {
        try {
            model.setAvion(aerolinea.logica.Model.getInstance().getAvion(id));
        } catch (Throwable ex) {
            Avion a = new Avion("El avión no existe");
            List<Tipoavion> aux = this.model.getTiposAviones();
            if (aux.size() > 0) {
                a.setTipoavion(aux.get(0));
            }
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
            Avion e = new Avion();
            e.setTipoavion(this.model.getTiposAviones().get(0));
            this.model.setAvion(e);
        } catch (Throwable ex) {
        }
    }

    public void show() {
        this.iniciar();
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

}
