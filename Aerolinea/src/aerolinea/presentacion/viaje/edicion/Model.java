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
    private List<Integer> dayList;

    public Model() {
        this.viaje = new Viaje();
        this.vuelos = new ArrayList<>();
        this.annios = new ArrayList<>();
        this.asientos = new ArrayList<>();
        this.meses = new ArrayList<>();
        this.dayList = new ArrayList<>();
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

    public List<Integer> getDayList() {
        return dayList;
    }

    public void setDayList(List<Integer> dayList) {
        this.dayList = dayList;
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

        this.meses.add("Enero");
        this.meses.add("Febrero");
        this.meses.add("Marzo");
        this.meses.add("Abril");
        this.meses.add("Mayo");
        this.meses.add("Junio");
        this.meses.add("Julio");
        this.meses.add("Agosto");
        this.meses.add("Setiembre");
        this.meses.add("Octubre");
        this.meses.add("Noviembre");
        this.meses.add("Diciembre");

        this.monthDay(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR),
                java.util.Calendar.getInstance().get(java.util.Calendar.MONTH));

    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public void monthDay(int year, int month) {

        YearMonth yMonth = YearMonth.of(year, Month.of(month + 1));
        int diff = this.dayList.size() - yMonth.lengthOfMonth();
        int arrayIndex = 0;
        if (!this.dayList.isEmpty()) {
            arrayIndex = this.dayList.size() - 1;
        }
        // ADD
        if (diff < 0) {
            diff *= -1;
            for (int u = 0; u < diff; u++) {
                if (this.dayList.isEmpty()) {
                    this.dayList.add(1);
                } else {
                    this.dayList.add(this.dayList.get(arrayIndex++) + 1);
                }
            }
        } // REMOVE
        else if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                this.dayList.remove(arrayIndex--);
            }
        }

    }

    private static final int YEAR_RANGE = 50;
    public static final int MIN_ASIENTOS = 50;
}
