/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.formaPago.listado;

import aerolinea.logica.Formapago;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class FormaPagoTableModel extends AbstractTableModel {

    List<Formapago> formasPago;

    public FormaPagoTableModel(List<Formapago> formasPago) {
        this.formasPago = formasPago;
    }

    public List<Formapago> getFormasPago() {
        return this.formasPago;
    }

    public void setFormasPago(List<Formapago> formasPago) {
        this.formasPago = formasPago;
    }

    @Override
    public int getRowCount() {
        return this.formasPago.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Formapago f = formasPago.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return f.getIdFormaPago();
            case NOMBRE:
                return f.getNombreFormaPago();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case NOMBRE:
                return "Nombre";
            default:
                return "";
        }
    }
    private final int ID = 0;
    private final int NOMBRE = 1;
    private final int CANTIDAD_COLUMNAS = 2;
}
