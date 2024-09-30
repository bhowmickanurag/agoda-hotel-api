package org.example.atlassian.snakegame.entity;

public class Utils {

    public static Cell getCellAfterMove(Cell startCell, Direction direction) {
        int r = startCell.row;
        int c = startCell.col;
        switch (direction){
            case TOP:
                return new Cell(r-1, c);
            case BOTTOM:
                return new Cell(r+1, c);
            case LEFT:
                return new Cell(r, c+1);
            case RIGHT:
                return new Cell(r, c-1);
        }
        return null;
    }
}
