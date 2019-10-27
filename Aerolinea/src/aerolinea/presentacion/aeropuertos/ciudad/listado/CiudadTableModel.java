/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.ciudad.listado;

import aerolinea.logica.Ciudad;
import aerolinea.logica.Pais;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class CiudadTableModel extends AbstractTableModel {

    List<Ciudad> ciudades;

    public CiudadTableModel(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Ciudad> getCiudades() {
        return this.ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public int getRowCount() {
        return this.ciudades.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ciudad c = ciudades.get(rowIndex);
        switch (columnIndex) {
            case NOMBRE:
                return c.getNombre();
            case ABREVIATURA_PAIS:
                return c.getPais().getAbreviatura();
            case NOMBRE_PAIS:
                return c.getPais().getNombre();
            case BANDERA_PAIS:
                return this.bandera(c.getPais());
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case BANDERA_PAIS:
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
            case NOMBRE:
                return "Nombre";
            case ABREVIATURA_PAIS:
                return "ID";
            case NOMBRE_PAIS:
                return "Nombre del país";
            case BANDERA_PAIS:
                return "";
            default:
                return "";
        }
    }
    private final int NOMBRE = 0;
    private final int ABREVIATURA_PAIS = 1;
    private final int NOMBRE_PAIS = 2;
    private final int BANDERA_PAIS = 3;
    private final int CANTIDAD_COLUMNAS = 4;

}
