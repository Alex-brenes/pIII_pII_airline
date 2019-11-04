/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.usuario.history;

import aerolinea.logica.Reserva;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class ReservaTableModel extends AbstractTableModel {

    private List<Reserva> reservas;

    public ReservaTableModel(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva r = reservas.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return r.getIdReserva();
            case DOCUMENTO:
                return r.getDocumento();
            case FORMAPAGO:
                return r.getFormapago().getIdFormaPago();
            case CANTIDAD:
                return r.getCantidad();
            case ID_VIAJE:
                return r.getViaje().getIdViaje();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return "ID";
            case DOCUMENTO:
                return "Documento";
            case FORMAPAGO:
                return "Forma de pago";
            case CANTIDAD:
                return "Cantidad";
            case ID_VIAJE:
                return "ID del viaje";
            default:
                return "";
        }
    }

    private final int ID = 0;
    private final int DOCUMENTO = 1;
    private final int FORMAPAGO = 2;
    private final int CANTIDAD = 3;
    private final int ID_VIAJE = 4;
    private final int CANTIDAD_COLUMNAS = 5;

}
