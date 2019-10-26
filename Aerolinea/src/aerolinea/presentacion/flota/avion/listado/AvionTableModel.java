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
            case ID_TIPO:
                return a.getTipoavion().getIdTipoAvion();
            case MARCA:
                return a.getTipoavion().getMarca();
            case ANNIO:
                return a.getTipoavion().getAnnio();
            case MODELO:
                return a.getTipoavion().getModelo();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case ID_TIPO:
                return "ID Tipo de avión";
            case MARCA:
                return "Marca";
            case ANNIO:
                return "Año";
            case MODELO:
                return "Modelo";
            default:
                return "";
        }
    }
    private final int ID = 0;
    private final int ID_TIPO = 1;
    private final int MARCA = 2;
    private final int ANNIO = 3;
    private final int MODELO = 4;
    private final int CANTIDAD_COLUMNAS = 5;
}
