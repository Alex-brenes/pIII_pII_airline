/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.check_in;

import aerolinea.logica.Tiquete;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class SeatTableModel extends AbstractTableModel {

    private BiArray<Tiquete> array;

    public SeatTableModel(BiArray<Tiquete> array) {
        this.array = array;
        COLUMNS = array.getRow();
        ROWS = array.getColumn();
    }

    @Override
    public int getRowCount() {
        //  for transposed array
        return this.array.getColumn();
    }

    @Override
    public int getColumnCount() {
        //  for transposed array
        return this.array.getRow();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.getImage(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Icon.class;
    }

    private Icon getImage(int rowIndex, int columnIndex) {
        return new ImageIcon(getClass().getResource(
                (this.array.get(columnIndex, rowIndex) == null
                ? AVAILABLE_SEAT_PATH
                : NON_AVAILABLE_SEAT_PATH)));
    }

    @Override
    public String getColumnName(int columnIndex) {
        return Integer.toString(columnIndex);
    }
    private static final String AVAILABLE_SEAT_PATH = "../recursos/available.png";
    private static final String NON_AVAILABLE_SEAT_PATH = "../recursos/nonavailable.png";
    private static int COLUMNS;
    private static int ROWS;
}
