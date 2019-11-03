/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.purchase;

import java.util.List;
import java.util.Observable;
import aerolinea.logica.Formapago;
import aerolinea.logica.Tiquete;
import java.util.ArrayList;
import java.util.Observer;
import aerolinea.logica.Viaje;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private List<Formapago> formaPago;
    private Viaje viaje;
    private List<Tiquete> selectedSeats;

    public Model() {
        formaPago = new ArrayList<Formapago>();
        viaje = new Viaje();
        selectedSeats = new ArrayList<Tiquete>();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Tiquete> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<Tiquete> selectedSeats) {
        this.selectedSeats = selectedSeats;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Formapago> getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(List<Formapago> formaPago) {
        this.formaPago = formaPago;
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
