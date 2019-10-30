/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.pais.edicion;

import aerolinea.logica.Pais;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Model extends Observable {

    private Pais pais;
    private List<Pais> paises;

    public Model() {
        this.pais = new Pais();
        this.paises = new ArrayList<>();
        this.iniciar();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
        this.setChanged();
        this.notifyObservers();
    }

    public void iniciar() {
        try {
            String line = null;
            FileReader handler = new FileReader("paises.txt");
            BufferedReader bufferedReader = new BufferedReader(handler);

            while ((line = bufferedReader.readLine()) != null) {
                String codigo = "";
                String nombre = "";
                int c = 0;
                while (line.charAt(c) != '-') {
                    codigo += line.charAt(c++);
                }
                while (line.charAt(c) != '\n') {
                    nombre += line.charAt(c++);
                }
                this.paises.add(new Pais(codigo, nombre));
            }

            bufferedReader.close();

        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
            //Se cargan dos países de prueba
            this.paises.add(new Pais("_", "Unknown"));
            this.paises.add(new Pais("CR", "Costa Rica"));
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

    private final String PAISES = "countries.txt";
    private final Integer ISO = 2;

}
