/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelo.publicGUI;

import aerolinea.logica.Ciudad;
import aerolinea.logica.Viaje;
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

    private Viaje viajeToSearch;
    private List<Viaje> trips;
    private List<Ciudad> cities;

    // Date
    private List<Integer> years;
    private List<String> months;
    private List<Integer> days;

    public Model() {
        this.viajeToSearch = new Viaje();
        this.trips = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.years = new ArrayList<>();
        this.months = new ArrayList<>();
        this.days = new ArrayList<>();
        this.iniciarListas();
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public Viaje getViajeToSearch() {
        return viajeToSearch;
    }

    public void setViajeToSearch(Viaje viajeToSearch) {
        this.viajeToSearch = viajeToSearch;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Viaje> getTrips() {
        return trips;
    }

    public void setTrips(List<Viaje> trips) {
        this.trips = trips;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Ciudad> getCities() {
        return cities;
    }

    public void setCities(List<Ciudad> cities) {
        this.cities = cities;
        this.cities.add(0, null);
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    public void monthDay(int year, int month) {

        YearMonth yMonth = YearMonth.of(year, Month.of(month + 1));
        int diff = this.days.size() - yMonth.lengthOfMonth();
        int arrayIndex = 0;
        if (!this.days.isEmpty()) {
            arrayIndex = this.days.size() - 1;
        }
        // ADD
        if (diff < 0) {
            diff *= -1;
            for (int u = 0; u < diff; u++) {
                if (this.days.isEmpty()) {
                    this.days.add(1);
                } else {
                    this.days.add(this.days.get(arrayIndex++) + 1);
                }
            }
        } // REMOVE
        else if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                this.days.remove(arrayIndex--);
            }
        }
        this.years.add(0, null);
        this.months.add(0, null);
        this.days.add(0, null);
    }

    private void iniciarListas() {

        int annio = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int limiteAnnio = annio + YEAR_RANGE;
        while (annio <= limiteAnnio) {
            this.years.add(annio);
            annio++;
        }

        this.months.add("Enero");
        this.months.add("Febrero");
        this.months.add("Marzo");
        this.months.add("Abril");
        this.months.add("Mayo");
        this.months.add("Junio");
        this.months.add("Julio");
        this.months.add("Agosto");
        this.months.add("Setiembre");
        this.months.add("Octubre");
        this.months.add("Noviembre");
        this.months.add("Diciembre");

        this.monthDay(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR),
                java.util.Calendar.getInstance().get(java.util.Calendar.MONTH));

    }
    private static final int YEAR_RANGE = 50;
}
