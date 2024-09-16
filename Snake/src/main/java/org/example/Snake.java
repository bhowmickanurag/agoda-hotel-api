package org.example;

import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class Snake {

  private LinkedList<Cell> cells;

  Snake(Cell initialCell) {
    this.cells = new LinkedList<>();
    this.cells.add(initialCell);
  }

  public boolean isCrashed(Cell nextCell) {
    for (Cell cell : cells) {
      if (cell.equals(nextCell)) {
        return true;
      }
    }
    return false;
  }

  public void move(Cell nextCell) {
    this.cells.add(nextCell);
    this.cells.removeFirst();
  }

  public void grow(Cell nextCell) {
    this.cells.add(nextCell);
  }

  public Cell getHead() {
    return this.cells.getLast();
  }
}
