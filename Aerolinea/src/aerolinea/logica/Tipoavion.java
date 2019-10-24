/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    @Column(name = "idTipoAvion")
    private String idTipoAvion;
    @Column(name = "marca")
    private String marca;
    @Column(name = "annio")
    private Integer annio;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "cantidadPasajeros")
    private Integer cantidadPasajeros;
    @Column(name = "cantidadFilas")
    private Integer cantidadFilas;
    @Column(name = "asientosPorFila")
    private Integer asientosPorFila;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoavion")
    private List<Avion> avionList;

    public Tipoavion() {
    }

    public Tipoavion(String idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public String getIdTipoAvion() {
        return idTipoAvion;
    }

    public void setIdTipoAvion(String idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(Integer cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public Integer getAsientosPorFila() {
        return asientosPorFila;
    }

    public void setAsientosPorFila(Integer asientosPorFila) {
        this.asientosPorFila = asientosPorFila;
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
        hash += (idTipoAvion != null ? idTipoAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoavion)) {
            return false;
        }
        Tipoavion other = (Tipoavion) object;
        if ((this.idTipoAvion == null && other.idTipoAvion != null) || (this.idTipoAvion != null && !this.idTipoAvion.equals(other.idTipoAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Tipoavion[ idTipoAvion=" + idTipoAvion + " ]";
    }
    
}
