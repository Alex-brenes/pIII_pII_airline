/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "tiquete")
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTiquete")
    private Integer idTiquete;
    @Column(name = "fila")
    private String fila;
    @Column(name = "asiento")
    private Integer asiento;
    @JoinColumn(name = "reserva", referencedColumnName = "idReserva")
    @ManyToOne(optional = false)
    private Reserva reserva;

    public Tiquete() {
    }

    public Tiquete(String fila, Integer asiento, Reserva reserva) {
        this.fila = fila;
        this.asiento = asiento;
        this.reserva = reserva;
    }

    public Tiquete(Integer idTiquete) {
        this.idTiquete = idTiquete;
    }

    public Integer getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(Integer idTiquete) {
        this.idTiquete = idTiquete;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiquete != null ? idTiquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idTiquete == null && other.idTiquete != null) || (this.idTiquete != null && !this.idTiquete.equals(other.idTiquete))) {
            return false;
        }
        if ((this.asiento == null && other.asiento != null) || (this.asiento != null && !this.asiento.equals(other.asiento))) {
            return false;
        }
        if ((this.fila  == null && other.fila != null) || (this.fila != null && !this.fila.equals(other.fila))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asiento " + fila + Integer.toString(asiento);
    }

}
