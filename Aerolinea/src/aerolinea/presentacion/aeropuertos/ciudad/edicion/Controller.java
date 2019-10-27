/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.ciudad.edicion;

import aerolinea.logica.Avion;
import aerolinea.logica.Ciudad;
import aerolinea.logica.Pais;
import java.util.List;

/**
 *
 * @author pc
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(model);
        this.view.setController(this);
        this.iniciar();
    }

    public void iniciar() {
        try {
            this.model.setPaises(aerolinea.logica.Model.getInstance().searchPais());
        } catch (Throwable ex) {
        }
        List<Pais> aux = this.model.getPaises();
        if (aux.size() > 0) {
            this.model.getCiudad().setPais(this.model.getPaises().get(0));
        }
        this.model.setChanged();
        this.model.notifyObservers();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void consultar(String id) {
        try {
            model.setCiudad(aerolinea.logica.Model.getInstance().getCiudad(id));
        } catch (Throwable ex) {
            Ciudad c = new Ciudad("La ciudad no existe");
            List<Pais> aux = this.model.getPaises();
            if (aux.size() > 0) {
                c.setPais(aux.get(0));
            }
            this.model.setCiudad(c);
        }
    }

    public void modificar(Ciudad a) {
        try {
            aerolinea.logica.Model.getInstance().updateCiudad(a);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void agregar(Ciudad c) {
        try {
            aerolinea.logica.Model.getInstance().addCiudad(c);
            Ciudad e = new Ciudad();
            e.setPais(this.model.getPaises().get(0));
            this.model.setCiudad(e);
        } catch (Throwable ex) {
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    public void show() {
        this.iniciar();
        this.view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

}
