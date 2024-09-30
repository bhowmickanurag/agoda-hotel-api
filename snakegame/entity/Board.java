package org.example.atlassian.snakegame.entity;

import org.example.atlassian.snakegame.exception.InvalidPositionException;

public class Board {
    int rows;
    int columns;
    Cell[][] cells;

    public Board(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        cells = new Cell[rows][columns];
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int r, int c) {
        if (r >= 0 && c >= 0 && r < rows && c < columns) {
            return cells[r][c];
        }
        return null;
    }
}
