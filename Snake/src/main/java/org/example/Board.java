package org.example;

import lombok.Data;

@Data
public class Board {

  private Cell[][] cells;
  private int totalRows;
  private int totalColumns;

  Board(int rows, int columns) {
    this.totalRows = rows;
    this.totalColumns = columns;
    this.cells = new Cell[rows][columns];
    for (int i=0; i<rows; i++) {
      for (int j=0; j<columns; j++) {
        this.cells[i][j] = new Cell(i, j);
      }
    }
  }
}
