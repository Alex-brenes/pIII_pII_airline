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

    public Model() {
        this.tipoAvion = new Tipoavion();
        this.annios = new ArrayList<Integer>();
        this.iniciarAnnios();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    private void iniciarAnnios() {
        for (int annios = 1980; annios <= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); annios++) {
            this.annios.add(annios);
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

}
