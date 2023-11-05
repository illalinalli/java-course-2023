package edu.hw4_Mazes;

import java.util.List;

public class ConsoleRenderer implements Renderer {
    private static final String WALL_CHAR = "█";
    private static final String PASSAGE_CHAR = " ";
    private static final String PATH_CHAR = "*";

    @Override
    public String render(Maze maze) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getGrid()[row][col];
                sb.append(cell.type() == Cell.Type.WALL ? WALL_CHAR : PASSAGE_CHAR);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (path.contains(coordinate)) {
                    sb.append(PATH_CHAR);
                } else {
                    Cell cell = maze.getGrid()[row][col];
                    sb.append(cell.type() == Cell.Type.WALL ? WALL_CHAR : PASSAGE_CHAR);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
