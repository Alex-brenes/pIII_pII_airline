/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.history;

import aerolinea.logica.Reserva;
import aerolinea.logica.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    Usuario user;
    List<Reserva> reservas;

    public Model() {
        reservas = new ArrayList<Reserva>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        this.setChanged();
        this.notifyObservers();
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

}
