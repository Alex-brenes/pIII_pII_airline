/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.formaPago.edicion;

import aerolinea.logica.Formapago;

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

    public void agregar(Formapago f) {
        try {
            aerolinea.logica.Model.getInstance().addFormaPago(f);
            this.model.setFormaPago(new Formapago());
        } catch (Throwable ex) {
            this.model.setFormaPago(new Formapago("No se pudo", "agregar"));
        }
    }

    public void consultar(String id) {
        try {
            model.setFormaPago(aerolinea.logica.Model.getInstance().getFormaPago(id));
        } catch (Throwable ex) {
            this.model.setFormaPago(new Formapago("No existe la", "forma de pago"));
        }
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    void modificar(Formapago f) {
        try {
            aerolinea.logica.Model.getInstance().updateFormaPago(f);
        } catch (Throwable ex) {
            this.model.setFormaPago(new Formapago("No existe la", "forma de pago"));
        }
    }
}
