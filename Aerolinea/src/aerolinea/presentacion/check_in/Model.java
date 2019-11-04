/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.check_in;

import aerolinea.logica.Reserva;
import aerolinea.logica.Tiquete;
import aerolinea.logica.Viaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private List<Tiquete> selectedSeats;
    private BiArray<Tiquete> array;
    private Viaje viaje;
    private Reserva reserva;

    public Model() {
        restart();
    }

    public void restart() {
        this.selectedSeats = new ArrayList<Tiquete>();
        this.viaje = new Viaje();
        this.reserva = new Reserva();
        this.init();
    }

    public List<Tiquete> getSelectedSeats() {
        return selectedSeats;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
        this.setChanged();
        this.notifyObservers();

    }

    public void setSelectedSeats(List<Tiquete> selectedSeats) {
        this.selectedSeats = selectedSeats;
        this.setChanged();
        this.notifyObservers();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
        init();
        this.setChanged();
        this.notifyObservers();
    }

    public BiArray<Tiquete> getArray() {
        return array;
    }

    public void setArray(BiArray<Tiquete> array) {
        this.array = array;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    private void init() {
        this.array = new BiArray<Tiquete>(this.viaje.getVuelo().getAvion().getTipoavion().getCantidadFilas(),
                this.viaje.getVuelo().getAvion().getTipoavion().getAsientosPorFila());
        for (int x = 0; x < this.array.getRow(); x++) {
            for (int y = 0; y < this.array.getColumn(); y++) {
                this.array.add(x, y, null);
            }
        }
        for (Reserva r : viaje.getReservaList()) {
            for (Tiquete t : r.getTiqueteList()) {
                this.array.add(
                        t.getAsiento(),
                        getArrayColumn(t.getFila()),
                        t);
            }
        }
    }

    public int getArrayColumn(String c) {
        switch (c.charAt(0)) {
            case '\u0041':
                return 0;
            case '\u0042':
                return 1;
            case '\u0043':
                return 2;
            case '\u0044':
                return 3;
            case '\u0045':
                return 4;
            case '\u0046':
                return 5;
            case '\u0047':
                return 6;
            default:
                return -1;
        }
    }

}
