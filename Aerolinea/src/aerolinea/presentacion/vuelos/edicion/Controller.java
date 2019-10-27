/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelos.edicion;

import aerolinea.logica.Vuelo;
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
        this.view.setModel(model);
        this.view.setController(this);
        this.iniciarComponentes();
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

    public void consultar(String id) {
        try {
            model.setVuelo(aerolinea.logica.Model.getInstance().getVuelo(id));
        } catch (Throwable ex) {
            Vuelo v = new Vuelo("El vuelo no existe");
            if (this.model.getAviones().size() > 0) {
                v.setAvion(this.model.getAviones().get(0));
            }
            if (this.model.getCiudades().size() > 0) {
                v.setOrigen(this.model.getCiudades().get(0));
                v.setDestino(this.model.getCiudades().get(0));
            }
            this.model.setVuelo(v);
        }
    }

    public void modificar(Vuelo v) {
        try {
            aerolinea.logica.Model.getInstance().updateVuelo(v);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void agregar(Vuelo v) {
        try {
            aerolinea.logica.Model.getInstance().addVuelo(v);
            Vuelo e = new Vuelo();
            if (this.model.getAviones().size() > 0) {
                e.setAvion(this.model.getAviones().get(0));
            }
            if (this.model.getCiudades().size() > 0) {
                e.setOrigen(this.model.getCiudades().get(0));
                e.setDestino(this.model.getCiudades().get(0));
            }
            this.model.setVuelo(e);
        } catch (Throwable ex) {
        }
    }

    public void show() {
        this.iniciarComponentes();
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    private void iniciarComponentes() {
        try {
            this.model.setAviones(aerolinea.logica.Model.getInstance().searchAvion());
            if (this.model.getVuelo().getAvion() == null && this.model.getAviones().size() > 0) {
                this.model.getVuelo().setAvion(this.model.getAviones().get(0));
            }
        } catch (Throwable ex) {
        }
        try {
            this.model.setCiudades(aerolinea.logica.Model.getInstance().searchCiudad());
            if (this.model.getVuelo().getOrigen() == null && this.model.getCiudades().size() > 0) {
                this.model.getVuelo().setOrigen(this.model.getCiudades().get(0));
                this.model.getVuelo().setDestino(this.model.getCiudades().get(0));
            }
        } catch (Throwable ex) {
        }
    }
}
