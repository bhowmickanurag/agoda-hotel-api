package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cell {

  private int row;
  private int column;

  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
  }
}
