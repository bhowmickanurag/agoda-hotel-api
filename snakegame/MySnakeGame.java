package org.example.atlassian.snakegame;

import org.example.atlassian.snakegame.entity.*;

import java.util.LinkedList;

public class MySnakeGame extends SnakeGame {

    LinkedList<Cell> availableFood;

    public MySnakeGame(int rows, int columns, int[][] food) {
        super(rows, columns, food);
        availableFood = new LinkedList<>();
        for(int i = 0 ; i < food.length ; i++) {
            Cell cell = board.getCell(food[i][0], food[i][1]);
            availableFood.add(cell);
        }
    }

    @Override
    public synchronized int move(Direction direction) {
        Cell snakeHead = snake.getHeadOfSnake();
        Cell cellAfterMove = getCellAfterMove(snakeHead, direction, false);
        if(cellAfterMove == null)
            return -1;
        if(!availableFood.isEmpty() && availableFood.peekLast().equals(cellAfterMove)) {
            // there is food at the new position
            if(!snake.grow(cellAfterMove))
                return -1;
            availableFood.removeLast();
        } else{
            if(!snake.move(cellAfterMove))
                return -1;
        }
        return snake.getLength();
    }

    public Cell getCellAfterMove(Cell current, Direction direction, boolean enableWrapping) {
        int r = current.getRow();
        int c = current.getCol();
        int newRow = r;
        int newColumn = c;
        switch (direction){
            case TOP:
                newRow = current.getRow()-1;
                break;
            case BOTTOM:
                newRow = current.getRow()+1;
                break;
            case LEFT:
                newColumn = current.getCol()+1;
                break;
            case RIGHT:
                newColumn = current.getCol()-1;
                break;
        }
        if(enableWrapping) {
            newRow = (newRow + board.getRows()) % board.getRows();
            newColumn = (newColumn + board.getColumns()) % board.getColumns();
        }
        return board.getCell(newRow, newColumn);
    }
}
