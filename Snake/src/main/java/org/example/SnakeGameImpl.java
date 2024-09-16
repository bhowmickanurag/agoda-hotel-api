package org.example;

import lombok.Getter;

@Getter
public class SnakeGameImpl implements SnakeGame {

  private static final int SNAKE_GROW_MOVE = 5;

  private final Board board;
  private final Snake snake;
  private int numMoves;
  private boolean isGameOver;

  SnakeGameImpl(int rows, int columns) {
    this.board = new Board(rows, columns);
    this.snake = new Snake(this.board.getCells()[0][0]);
    this.numMoves = 0;
    this.isGameOver = false;
  }

  @Override
  public void moveSnake(SnakeDirection snakeDirection) {
    this.numMoves++;
    Cell nextCell = getNextCell(this.snake.getHead(), snakeDirection);
    if (this.snake.isCrashed(nextCell)) {
      this.isGameOver = true;
      return;
    }
    if (this.numMoves%SNAKE_GROW_MOVE == 0) {
      this.snake.grow(nextCell);
    } else {
      this.snake.move(nextCell);
    }
  }

  @Override
  public boolean isGameOver() {
    return this.isGameOver;
  }

  private Cell getNextCell(Cell currentCell, SnakeDirection snakeDirection) {
    switch (snakeDirection) {
      case UP -> {
        int newColumn = (currentCell.getColumn() + this.board.getTotalColumns() - 1) % this.board.getTotalColumns();
        return this.board.getCells()[currentCell.getRow()][newColumn];
      }
      case DOWN -> {
        int newColumn = (currentCell.getColumn() + this.board.getTotalColumns() + 1) % this.board.getTotalColumns();
        return this.board.getCells()[currentCell.getRow()][newColumn];
      }
      case LEFT -> {
        int newRow = (currentCell.getRow() + this.board.getTotalRows() - 1) % this.board.getTotalRows();
        return this.board.getCells()[newRow][currentCell.getColumn()];
      }
      case RIGHT -> {
        int newRow = (currentCell.getRow() + this.board.getTotalRows() + 1) % this.board.getTotalRows();
        return this.board.getCells()[newRow][currentCell.getColumn()];
      }
    }
    throw new RuntimeException("Incorrect direction");
  }
}
