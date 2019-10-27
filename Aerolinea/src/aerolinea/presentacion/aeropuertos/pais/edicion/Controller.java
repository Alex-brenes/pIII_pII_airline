/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.pais.edicion;

import aerolinea.logica.Pais;

/**
 *
 * @author pc
 */
public class Controller {

    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        this.view.setModel(this.model);
        this.view.setController(this);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void agregar(Pais p) {
        try {
            aerolinea.logica.Model.getInstance().addPais(p);
            this.model.setPais(this.model.getPaises().get(0));
        } catch (Throwable ex) {
        }
    }

    public void consultar(String abreviatura) {
        try {
            model.setPais(aerolinea.logica.Model.getInstance().getPais(abreviatura));
        } catch (Throwable ex) {
        }
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

}
