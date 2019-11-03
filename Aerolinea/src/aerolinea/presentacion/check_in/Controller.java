/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.check_in;

import aerolinea.logica.Tiquete;
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
        this.view.setModel(this.model);
        this.view.setController(this);
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

    public void setView(View view) {
        this.view = view;
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    public void setViaje(aerolinea.logica.Viaje v) {
        this.model.setViaje(v);
    }

    void changeFlag(int x, int y) {
        if (this.model.getArray().get(x, y) == null) {
            if (model.getSelectedSeats().size() < 8) {
                model.getSelectedSeats().add(new Tiquete(toColumn(y), x, model.getReserva()));
                model.getArray().add(x, y, model.getSelectedSeats().get(model.getSelectedSeats().size() - 1));
            }
        } else {
            if (model.getSelectedSeats().contains(this.model.getArray().get(x, y))) {
                model.getSelectedSeats().remove(model.getArray().get(x, y));
                model.getArray().remove(x, y);
            }
        }
        this.model.setChanged();
        this.model.notifyObservers();
    }

    public String toColumn(int i) {
        switch (i) {
            case 0:
                return Character.toString('\u0041');
            case 1:
                return Character.toString('\u0042');
            case 2:
                return Character.toString('\u0043');
            case 3:
                return Character.toString('\u0044');
            case 4:
                return Character.toString('\u0045');
            case 5:
                return Character.toString('\u0046');
            case 6:
                return Character.toString('\u0047');
            default:
                return "Z";
        }
    }

    void purchase() {
        if (aerolinea.Application.APPLICATION_CONTROLLER.getModel().getUser().getNombre() == "") {
            aerolinea.Application.LOGIN_CONTROLLER.show();
        } else {
            aerolinea.Application.PURCHASE_CONTROLLER.Show();
            aerolinea.Application.PURCHASE_CONTROLLER.setEntities(model.getSelectedSeats(), model.getViaje());
        }
        hide();
    }

}
