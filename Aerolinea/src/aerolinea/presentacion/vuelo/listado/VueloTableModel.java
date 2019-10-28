/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.vuelo.listado;

import aerolinea.logica.Pais;
import aerolinea.logica.Vuelo;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class VueloTableModel extends AbstractTableModel {

    List<Vuelo> vuelos;

    public VueloTableModel(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Vuelo> getVuelos() {
        return this.vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public int getRowCount() {
        return this.vuelos.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vuelo v = vuelos.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return v.getIdVuelo();
            case DIA:
                return v.getDia();
            case HORA:
                return v.getHora().toString();
            case ORIGEN:
                return v.getOrigen().toString();
            case BANDERA_ORIGEN:
                return this.bandera(v.getOrigen().getPais());
            case DESTINO:
                return v.getDestino().toString();
            case BANDERA_DESTINO:
                return this.bandera(v.getDestino().getPais());
            case AVION:
                return v.getAvion().toString();
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case BANDERA_ORIGEN:
                return Icon.class;
            case BANDERA_DESTINO:
                return Icon.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    private Icon bandera(Pais p) {
        String file = p.getAbreviatura() + ".png";
        return new ImageIcon(getClass().getResource("../../recursos/64/" + file));
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case DIA:
                return "Día";
            case HORA:
                return "Hora";
            case ORIGEN:
                return "Origen";
            case BANDERA_ORIGEN:
                return "";
            case DESTINO:
                return "Destino";
            case BANDERA_DESTINO:
                return "";
            case AVION:
                return "ID del avión";
            default:
                return "";
        }
    }
    private final int ID = 0;
    private final int DIA = 1;
    private final int HORA = 2;
    private final int ORIGEN = 3;
    private final int BANDERA_ORIGEN = 4;
    private final int DESTINO = 5;
    private final int BANDERA_DESTINO = 6;
    private final int AVION = 7;
    private final int CANTIDAD_COLUMNAS = 8;
}
