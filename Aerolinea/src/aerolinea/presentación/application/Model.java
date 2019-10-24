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
package aerolinea.presentación.application;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private aerolinea.logica.Usuario user;

    public Model() {
        this.user = null;
    }

    public Model(aerolinea.logica.Usuario user) {
        this.user = user;
    }

    public void setUser(aerolinea.logica.Usuario user) {
        this.user = user;
    }

    @Override
    public void addObserver(Observer o) {
        this.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

}
