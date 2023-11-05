package edu.hw4_Mazes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DepthFirstGenerator implements Generator {
    private final Random random;

    public DepthFirstGenerator(Random random) {
        this.random = random;
    }

    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        // Создаем рандомные проходы
        for (int row = 0; row < height - 2; row += 2) {
            for (int col = 0; col < width - 2; col += 2) {
                if (random.nextBoolean()) {
                    int passageWidth = 1;
                    int passageStart = random.nextInt(width - col - passageWidth) + col;
                    for (int i = passageStart; i < passageStart + passageWidth; i++) {
                        grid[row][i] = new Cell(row, i, Cell.Type.PASSAGE);
                    }
                } else {
                    int passageWidth = 1;
                    int passageStart = random.nextInt(height - row - passageWidth) + row;
                    for (int i = passageStart; i < passageStart + passageWidth; i++) {
                        grid[i][col] = new Cell(i, col, Cell.Type.PASSAGE);
                    }
                }
            }
        }

        Stack<Coordinate> stack = new Stack<>();
        Coordinate start = new Coordinate(1, 1);
        stack.push(start);

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            List<Coordinate> neighbors = getUnvisitedNeighbors(current, grid);
            if (!neighbors.isEmpty()) {
                stack.push(current);
                Collections.shuffle(neighbors, random);
                Coordinate neighbor = neighbors.get(0);
                int row = (current.row() + neighbor.row()) / 2;
                int col = (current.col() + neighbor.col()) / 2;
                grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);
                grid[neighbor.row()][neighbor.col()] = new Cell(neighbor.row(), neighbor.col(), Cell.Type.PASSAGE);
                stack.push(neighbor);
            }
        }
        return new Maze(height, width, grid);
    }

    public List<Coordinate> getUnvisitedNeighbors(Coordinate current, Cell[][] grid) {
        List<Coordinate> neighbors = new ArrayList<>();
        int row = current.row();
        int col = current.col();
        if (row > 1 && grid[row - 2][col].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinate(row - 2, col));
        }
        if (row < grid.length - 2 && grid[row + 2][col].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinate(row + 2, col));
        }
        if (col > 1 && grid[row][col - 2].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinate(row, col - 2));
        }
        if (col < grid[0].length - 2 && grid[row][col + 2].type() == Cell.Type.WALL) {
            neighbors.add(new Coordinate(row, col + 2));
        }
        return neighbors;
    }
}
