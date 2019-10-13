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
package aerolinea.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "tipoavion")
@NamedQueries({
    @NamedQuery(name = "Tipoavion.findAll", query = "SELECT t FROM Tipoavion t")})
public class Tipoavion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @Column(name = "passengersQuantity")
    private int passengersQuantity;
    @Basic(optional = false)
    @Column(name = "rowsQuantity")
    private int rowsQuantity;
    @Basic(optional = false)
    @Column(name = "seatsRow")
    private int seatsRow;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoavion")
    private List<Avion> avionList;

    public Tipoavion() {
    }

    public Tipoavion(String id) {
        this.id = id;
    }

    public Tipoavion(String id, String brand, String year, String model, int passengersQuantity, int rowsQuantity, int seatsRow) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.passengersQuantity = passengersQuantity;
        this.rowsQuantity = rowsQuantity;
        this.seatsRow = seatsRow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengersQuantity() {
        return passengersQuantity;
    }

    public void setPassengersQuantity(int passengersQuantity) {
        this.passengersQuantity = passengersQuantity;
    }

    public int getRowsQuantity() {
        return rowsQuantity;
    }

    public void setRowsQuantity(int rowsQuantity) {
        this.rowsQuantity = rowsQuantity;
    }

    public int getSeatsRow() {
        return seatsRow;
    }

    public void setSeatsRow(int seatsRow) {
        this.seatsRow = seatsRow;
    }

    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoavion)) {
            return false;
        }
        Tipoavion other = (Tipoavion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Tipoavion[ id=" + id + " ]";
    }
    
}
