package aerolinea.presentacion.viaje.listado;

import aerolinea.logica.Pais;
import aerolinea.logica.Viaje;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private final int CANTIDAD_COLUMNAS = 6;
}
