/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.flota.avion.listado;

import aerolinea.logica.Avion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class AvionTableModel extends AbstractTableModel {

    List<Avion> aviones;

    public AvionTableModel(List<Avion> aviones) {
        this.aviones = aviones;
    }

    public List<Avion> getAviones() {
        return this.aviones;
    }

    public void setAviones(List<Avion> tipos) {
        this.aviones = aviones;
    }

    @Override
    public int getRowCount() {
        return this.aviones.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avion a = aviones.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return a.getId();
            case MARCA:
                return t.getMarca();
            case ANNIO:
                return t.getAnnio();
            case MODELO:
                return t.getModelo();
            case PASAJEROS:
                return t.getCantidadPasajeros();
            case FILAS:
                return t.getCantidadFilas();
            case ASIENTOS:
                return t.getAsientosPorFila();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case MARCA:
                return "Marca";
            case ANNIO:
                return "Año";
            case MODELO:
                return "Modelo";
            case PASAJEROS:
                return "Cantidad de pasajeros";
            case FILAS:
                return "Cantidad de filas";
            case ASIENTOS:
                return "Asientos por fila";
            default:
                return "";
        }
    }
    private final int ID = 0;
    private final int MARCA = 1;
    private final int ANNIO = 2;
    private final int MODELO = 3;
    private final int PASAJEROS = 4;
    private final int FILAS = 5;
    private final int ASIENTOS = 6;
    private final int CANTIDAD_COLUMNAS = 7;
}
