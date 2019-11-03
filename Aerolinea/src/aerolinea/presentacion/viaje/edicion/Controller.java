/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.viaje.edicion;

import aerolinea.logica.Viaje;
import aerolinea.logica.Vuelo;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
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
        this.iniciarListas();
    }

    public void consultar(Integer id) {
        try {
            model.setViaje(aerolinea.logica.Model.getInstance().getViaje(id));
        } catch (Throwable ex) {
            model.setViaje(new Viaje());
        }
    }

    public void modificar(Viaje v) {
        try {
            aerolinea.logica.Model.getInstance().updateViaje(v);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
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

    public void agregar(Viaje v) {
        try {
            aerolinea.logica.Model.getInstance().addViaje(v);
            this.model.setViaje(new Viaje());
        } catch (Throwable ex) {
        }
    }

    public void show() {
        this.iniciarListas();
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    private void iniciarListas() {
        try {
            model.setVuelos(aerolinea.logica.Model.getInstance().searchVuelo());
        } catch (Throwable ex) {
        }
        List<Vuelo> aux = this.model.getVuelos();
        if (aux.size() > 0) {
            this.model.getViaje().setVuelo(this.model.getVuelos().get(0));
            for (int i = this.model.MIN_ASIENTOS; i <= this.model.getVuelos().get(0).getAvion().getTipoavion().getCantidadPasajeros(); i++) {
                this.model.getAsientos().add(i);
            }
        }
        this.model.setChanged();
        this.model.notifyObservers();
    }

    public void cambiaAsientos(Vuelo v) {
        model.setAsientos(new ArrayList<Integer>());
        for (int i = model.MIN_ASIENTOS; i <= v.getAvion().getTipoavion().getCantidadPasajeros(); i++) {
            this.model.getAsientos().add(i);
        }

    }

    void diasMes(Integer annio, Integer mes) {
        this.model.monthDay(annio, mes);
        this.model.setChanged();
        this.model.notifyObservers();
    }

}
