/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelo.publicGUI;

import aerolinea.Application;
import aerolinea.logica.Ciudad;
import aerolinea.logica.Viaje;
import java.util.ArrayList;
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
        this.iniciarListas();
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
        this.model.setTrips(new ArrayList<Viaje>());
        this.model.setViajeToSearch(new Viaje());
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    private void iniciarListas() {
        try {
            this.model.setCities(aerolinea.logica.Model.getInstance().searchCiudad());
        } catch (Throwable ex) {

        }
    }

    void buscar(Viaje toViaje, String date) {
        Application.CHECK_IN_CONTROLLER.getModel().restart();
        try {
            this.model.setTrips(aerolinea.logica.Model.getInstance().searchViaje(toViaje, date));
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }

    void checkIn(int selectedRow) {
        hide();
        Application.CHECK_IN_CONTROLLER.setViaje(this.model.getTrips().get(selectedRow));
        Application.CHECK_IN_CONTROLLER.show();
    }

}
