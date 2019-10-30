/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.registro;

import aerolinea.logica.Usuario;
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

    private Usuario usuario;

    // Birth
    private List<Integer> years;
    private List<String> months;
    private List<Integer> days;

    public Model() {
        this.usuario = new Usuario();
        this.days = new ArrayList<>();
        this.months = new ArrayList<>();
        this.years = new ArrayList<>();
        this.iniciarListas();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
        this.setChanged();
        this.notifyObservers();
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
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

        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - YEAR_RANGE;
        int limiteAnnio = year + YEAR_RANGE;
        while (year <= limiteAnnio) {
            this.years.add(year);
            year++;
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

    }
    private static final int YEAR_RANGE = 150;
}
