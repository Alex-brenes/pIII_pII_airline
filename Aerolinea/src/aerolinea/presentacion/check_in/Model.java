/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.check_in;

import aerolinea.logica.Viaje;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    
    private BiArray<Boolean> array;
    private Viaje viaje;

    public Model() {
        this.viaje = new Viaje();
        this.array = new BiArray<Boolean>(this.viaje.getVuelo().getAvion().getTipoavion().getCantidadFilas(),
                this.viaje.getVuelo().getAvion().getTipoavion().getAsientosPorFila());
        this.init();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
        this.setChanged();
        this.notifyObservers();
    }

    public BiArray<Boolean> getArray() {
        return array;
    }

    public void setArray(BiArray<Boolean> array) {
        this.array = array;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public void setChanged(){
        super.setChanged();
    }
    
    @Override
    public void notifyObservers(){
        super.notifyObservers();
    }

    private void init() {
        for (int x = 0; x < this.array.getRow(); x++) {
            for (int y = 0; y < this.array.getColumn(); y++) {
                this.array.add(x, y, true);
            }
        }
    }

}
