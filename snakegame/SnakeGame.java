package org.example.atlassian.snakegame;

import org.example.atlassian.snakegame.entity.Board;
import org.example.atlassian.snakegame.entity.Cell;
import org.example.atlassian.snakegame.entity.Direction;
import org.example.atlassian.snakegame.entity.Snake;

public abstract class SnakeGame {

    int rows;
    int columns;
    int[][] food;
    Board board;
    Snake snake;

    public SnakeGame(int rows, int columns, int[][] food) {
        this.rows = rows;
        this.columns = columns;
        this.food = food;
        board = new Board(rows, columns);
        snake = new Snake(new Cell(0,0));
    }

    public abstract int move(Direction direction);
}
