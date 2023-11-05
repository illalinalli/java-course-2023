package edu.hw4_Mazes;

import java.lang.invoke.CallSite;
import java.lang.reflect.Type;
import java.util.List;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Cell getCell(int i, int i1) {
        return new Cell(i, i1, Cell.Type.PASSAGE);
    }
}
