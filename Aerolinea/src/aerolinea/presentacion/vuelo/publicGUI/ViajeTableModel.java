/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelo.publicGUI;

import aerolinea.logica.Viaje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class ViajeTableModel extends AbstractTableModel {

    List<Viaje> viajes;

    public ViajeTableModel(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public List<Viaje> getViajes() {
        return this.viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    @Override
    public int getRowCount() {
        return this.viajes.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Viaje v = viajes.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return v.getIdViaje();
            case FECHA:
                return (new java.sql.Date(v.getFecha().getTime())).toString();
            case HORA:
                return v.getVuelo().getHora().toString();
            case PRECIO:
                return v.getPrecio();
            case DISPONIBLES:
                return v.getDisponibles();
            case VUELO_ID:
                return v.getVuelo().getIdVuelo();
            case ORIGEN:
                return v.getVuelo().getOrigen();
            case DESTINO:
                return v.getVuelo().getDestino();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case FECHA:
                return "Fecha";
            case HORA:
                return "Hora";
            case PRECIO:
                return "Precio";
            case DISPONIBLES:
                return "Disponibles";
            case VUELO_ID:
                return "ID del vuelo";
            case ORIGEN:
                return "Origen";
            case DESTINO:
                return "Destino";
            default:
                return "";
        }
    }
    private final int ID = 0;
    private final int FECHA = 1;
    private final int HORA = 2;
    private final int PRECIO = 3;
    private final int DISPONIBLES = 4;
    private final int VUELO_ID = 5;
    private final int ORIGEN = 6;
    private final int DESTINO = 7;
    private final int CANTIDAD_COLUMNAS = 8;
}
