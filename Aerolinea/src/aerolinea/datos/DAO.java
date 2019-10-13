// DAO.java
// Author: José Alexander Brenes Brenes
// Description: DAO interface to query the database

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

package aerolinea.datos;
import java.util.List;

public interface DAO <T, K> {
    /*
        All classes that implement this interface must define a  RelDatabase reference
    */
    public abstract void add(T s) throws Exception;
    public abstract void delete(T s) throws Exception;
    public abstract T get(K s) throws Exception;
    public abstract void update(K s);
    public abstract List<T> searh(K s);
    
}
