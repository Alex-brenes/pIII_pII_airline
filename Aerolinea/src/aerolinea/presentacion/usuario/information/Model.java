/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.information;

import java.util.Observable;
import aerolinea.logica.Usuario;
import java.util.Observer;
/**
 *
 * @author pc
 */
public class Model extends Observable {
    
    private Usuario usuario;

    public Model() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
}
