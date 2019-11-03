/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.check_in;

/**
 *
 * @author pc
 */
public class BiArray<T> {

    private int row;
    private int column;
    private T array[][];
    private int elements;

    public BiArray() {
        this.row = ROW;
        this.column = COLUMN;
        this.elements = 0;
        this.init();
    }

    public BiArray(int row, int column) {
        this.row = row;
        this.column = column;
        this.init();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isEmpty() {
        return (this.elements == 0);
    }

    public boolean isFull() {
        return (this.elements == this.column * this.row);
    }

    public T get(int x, int y) {
        return this.array[x][y];
    }

    public static final int ROW = 10;
    public static final int COLUMN = 10;

    public void add(int x, int y, T e) {
        this.array[x][y] = e;
    }

    private void init() {
        this.array = (T[][]) (new Object[this.row][]);
        for (int i = 0; i < this.row; i++) {
            this.array[i] = (T[]) (new Object[this.column]);
        }
    }
    
    public void remove(int x, int y){
        array[x][y] = null;
    }

}
