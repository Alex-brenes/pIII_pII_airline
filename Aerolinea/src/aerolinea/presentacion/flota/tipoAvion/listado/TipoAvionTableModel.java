/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.flota.tipoAvion.listado;

import aerolinea.logica.Tipoavion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class TipoAvionTableModel extends AbstractTableModel {

    List<Tipoavion> tipos;

    public TipoAvionTableModel(List<Tipoavion> tipos) {
        this.tipos = tipos;
    }

    public List<Tipoavion> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipoavion> tipos) {
        this.tipos = tipos;
    }

    @Override
    public int getRowCount() {
        return this.tipos.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tipoavion t = tipos.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return t.getIdTipoAvion();
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
