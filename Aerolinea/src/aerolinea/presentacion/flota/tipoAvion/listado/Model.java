/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.flota.tipoAvion.listado;

import aerolinea.logica.Tipoavion;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private List<Tipoavion> tiposAviones;

    public Model(List<Tipoavion> tiposAviones) {
        this.tiposAviones = tiposAviones;
    }

    public Model() {
        this.tiposAviones = new ArrayList<>();
    }

    public List<Tipoavion> getTiposAviones() {
        return tiposAviones;
    }

    public void setTiposAviones(List<Tipoavion> tiposAviones) {
        this.tiposAviones = tiposAviones;
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

}
