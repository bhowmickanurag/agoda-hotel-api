package org.example.atlassian.snakegame.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Snake {

    LinkedList<Cell> snake;
    Set<Cell> occupied;

    public Snake(Cell start) {
        this.snake = new LinkedList<>();
        occupied = new HashSet<>();
        snake.add(start);
        occupied.add(start);
    }

    public boolean grow(Cell cell) {
        if(occupied.contains(cell)) {
            // sake will crash
            return false;
        }
        snake.add(cell);
        occupied.add(cell);
        return true;
    }

    public boolean move(Cell cell) {
        // move the tail
        Cell last = snake.removeLast();
        occupied.remove(last);
        if(occupied.contains(cell)) {
            // snake has crashed
            return false;
        }
        // occupy the new cell
        snake.addFirst(cell);
        occupied.add(cell);

        return true;
    }

    public int getLength() {
        return snake.size();
    }

    public Cell getHeadOfSnake() {
        return snake.peekFirst();
    }
}
