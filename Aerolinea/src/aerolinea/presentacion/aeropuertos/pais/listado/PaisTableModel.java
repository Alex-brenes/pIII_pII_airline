/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.aeropuertos.pais.listado;

import aerolinea.logica.Pais;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class PaisTableModel extends AbstractTableModel {

    List<Pais> paises;

    public PaisTableModel(List<Pais> paises) {
        this.paises = paises;
    }

    public List<Pais> getPaises() {
        return this.paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    @Override
    public int getRowCount() {
        return this.paises.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pais p = paises.get(rowIndex);
        switch (columnIndex) {
            case ABREVIATURA:
                return p.getAbreviatura();
            case NOMBRE:
                return p.getNombre();
            case BANDERA:
                return this.bandera(p);
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case BANDERA:
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
            case ABREVIATURA:
                return "ID";
            case NOMBRE:
                return "ID Tipo de avión";
            case BANDERA:
                return "";
            default:
                return "";
        }
    }
    private final int ABREVIATURA = 0;
    private final int NOMBRE = 1;
    private final int BANDERA = 2;
    private final int CANTIDAD_COLUMNAS = 3;
}
