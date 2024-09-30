package org.example.atlassian.snakegame.entity;

public class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;
            return (cell.getRow() == this.getRow() && cell.getCol() == this.getCol());
        }
        return super.equals(obj);
    }
}
