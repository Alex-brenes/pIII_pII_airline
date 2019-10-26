/*
 * Copyright (C) 2019 pc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package aerolinea.presentacion.flota.tipoAvion.edicion;

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

    private Tipoavion tipoAvion;
    private List<Integer> annios;
    private List<Integer> filas;
    private List<Integer> asientos;

    public Model() {
        this.tipoAvion = new Tipoavion();
        this.annios = new ArrayList<Integer>();
        this.filas = new ArrayList<Integer>();
        this.asientos = new ArrayList<Integer>();
        this.iniciarListas();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    private void iniciarListas() {
        for (int annios = Tipoavion.ANNIO_BASE; annios <= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); annios++) {
            this.annios.add(annios);
        }
        for (int filas = Tipoavion.MIN_FILAS; filas <= Tipoavion.MAX_FILAS; filas++) {
            this.filas.add(filas);
        }
        for (int asientos = Tipoavion.MIN_ASIENTOS; asientos <= Tipoavion.MAX_ASIENTOS; asientos++) {
            this.asientos.add(asientos);
        }
    }

    public Tipoavion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(Tipoavion tipoAvion) {
        this.tipoAvion = tipoAvion;
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

    public List<Integer> getFilas() {
        return filas;
    }

    public void setFilas(List<Integer> filas) {
        this.filas = filas;
    }

    public List<Integer> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Integer> asientos) {
        this.asientos = asientos;
    }

}
