/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelos.edicion;

import aerolinea.logica.Avion;
import aerolinea.logica.Ciudad;
import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private Vuelo vuelo;
    private List<String> dias;
    private List<Ciudad> ciudades;
    private List<Avion> aviones;
    // Hora
    private List<Integer> hora;
    private List<Integer> minuto;
    private List<Integer> segundo;

    public Model() {
        this.vuelo = new Vuelo();
        this.dias = new ArrayList<>();
        this.ciudades = new ArrayList<>();
        this.aviones = new ArrayList<>();
        this.hora = new ArrayList<>();
        this.minuto = new ArrayList<>();
        this.segundo = new ArrayList<>();
        this.iniciarListas();
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public List<Integer> getHora() {
        return hora;
    }

    public void setHora(List<Integer> hora) {
        this.hora = hora;
    }

    public List<Integer> getMinuto() {
        return minuto;
    }

    public void setMinuto(List<Integer> minuto) {
        this.minuto = minuto;
    }

    public List<Integer> getSegundo() {
        return segundo;
    }

    public void setSegundo(List<Integer> segundo) {
        this.segundo = segundo;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    private void iniciarListas() {
        for (int i = 0; i <= 23; i++) {
            this.hora.add(i);
        }
        for (int i = 0; i <= 59; i++) {
            this.minuto.add(i);
        }
        for (int i = 0; i <= 59; i++) {
            this.segundo.add(i);
        }
        this.dias.add("Domingo");
        this.dias.add("Lunes");
        this.dias.add("Martes");
        this.dias.add("Miércoles");
        this.dias.add("Jueves");
        this.dias.add("Viernes");
        this.dias.add("Sábado");
    }

}
