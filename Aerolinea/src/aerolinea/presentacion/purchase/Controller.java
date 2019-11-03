/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.purchase;

import aerolinea.Application;
import aerolinea.logica.Reserva;
import aerolinea.logica.Tiquete;
import java.util.List;

/**
 *
 * @author pc
 */
public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
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

    public void Show() {
        try {
            model.setFormaPago(aerolinea.logica.Model.getInstance().searchFormaPago());
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
        view.setVisible(true);
    }

    public void Hide() {
        view.setVisible(false);
        Application.CHECK_IN_CONTROLLER.getModel().restart();
    }

    public void setEntities(List<Tiquete> l, aerolinea.logica.Viaje v) {
        model.setSelectedSeats(l);
        model.setViaje(v);
    }

    void reserve(Reserva toReservation) {
        toReservation.setUsuario1(aerolinea.Application.APPLICATION_CONTROLLER.getModel().getUser());
        try {
            aerolinea.logica.Model.getInstance().addReserva(toReservation);
            for (Tiquete t : toReservation.getTiqueteList()) {
                aerolinea.logica.Model.getInstance().addTiquete(t);
                model.getViaje().setDisponibles(model.getViaje().getDisponibles() - 1);
            }
            aerolinea.logica.Model.getInstance().updateViaje(model.getViaje());
            Hide();

        } catch (Throwable ex) {

        }
    }

}
