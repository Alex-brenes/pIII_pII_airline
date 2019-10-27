/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.formaPago.listado;

import aerolinea.logica.Formapago;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class Model extends Observable {
    
        
    List<Formapago> formasPago;
    
    public Model(){
        this.formasPago = new ArrayList<>();
    }

    public List<Formapago> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(List<Formapago> formasPago) {
        this.formasPago = formasPago;
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
