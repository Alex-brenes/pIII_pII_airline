/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.viaje.edicion;

import aerolinea.logica.Viaje;
import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private Viaje viaje;
    private List<Vuelo> vuelos;
    private List<Integer> asientos;
    // Fecha
    private List<Integer> annios;
    private List<String> meses;
    private List<String> dias;

    public Model() {
        this.viaje = new Viaje();
        this.vuelos = new ArrayList<>();
        this.annios = new ArrayList<>();
        this.asientos = new ArrayList<>();
        this.iniciarListas();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public List<Integer> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Integer> asientos) {
        this.asientos = asientos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Integer> getAnnios() {
        return annios;
    }

    public void setAnnios(List<Integer> annios) {
        this.annios = annios;
        this.setChanged();
        this.notifyObservers();
    }

    public List<String> getMeses() {
        return meses;
    }

    public void setMeses(List<String> meses) {
        this.meses = meses;
        this.setChanged();
        this.notifyObservers();
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
        this.setChanged();
        this.notifyObservers();
    }

    private void iniciarListas() {

        int annio = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int limiteAnnio = annio + YEAR_RANGE;
        while (annio <= limiteAnnio) {
            this.annios.add(annio);
            annio++;
        }
//        for (int annios = Tipoavion.ANNIO_BASE; annios <= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); annios++) {
//            this.annios.add(annios);
//        }
//        for (int filas = Tipoavion.MIN_FILAS; filas <= Tipoavion.MAX_FILAS; filas++) {
//            this.filas.add(filas);
//        }
//        for (int asientos = Tipoavion.MIN_ASIENTOS; asientos <= Tipoavion.MAX_ASIENTOS; asientos++) {
//            this.asientos.add(asientos);
//        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    private static final int YEAR_RANGE = 50;
    public static final int MIN_ASIENTOS = 50;
}
