/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "vuelo")
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVuelo")
    private String idVuelo;
    @Column(name = "dia")
    private String dia;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Time hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<Viaje> viajeList;
    @JoinColumn(name = "avion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Avion avion;
    @JoinColumn(name = "origen", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Ciudad origen;
    @JoinColumn(name = "destino", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Ciudad destino;

    public Vuelo() {
        this.avion = new Avion();
        this.destino = new Ciudad();
        this.dia = DIA_DEFECTO;
        this.hora = new Time(0, 0, 0);
        this.idVuelo = "";
        this.origen = new Ciudad();
        this.viajeList = null;
    }

    public Vuelo(String idVuelo) {
        this.idVuelo = idVuelo;
        this.avion = null;
        this.destino = null;
        this.dia = DIA_DEFECTO;
        this.hora = new Time(0, 0, 0);
        this.origen = null;
        this.viajeList = null;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idVuelo + this.origen.toString() + " - " + this.destino.toString() + ". " + this.dia + " " + this.hora.toString();
    }

    private static final String DIA_DEFECTO = "Domingo";

}
