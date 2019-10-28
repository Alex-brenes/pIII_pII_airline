/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.viaje.listado;

import aerolinea.logica.Viaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {
        List<Viaje> viajes;
    
    public Model(){
        this.viajes = new ArrayList<>();
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

}
