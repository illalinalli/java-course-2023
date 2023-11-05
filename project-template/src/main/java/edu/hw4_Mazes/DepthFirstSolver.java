package edu.hw4_Mazes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DepthFirstSolver implements Solver {
    private final List<Coordinate> directions = Arrays.asList(
        new Coordinate(-1, 0), // вверх
        new Coordinate(0, 1), // вправо
        new Coordinate(1, 0), // вниз
        new Coordinate(0, -1) // влево
    );

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (current.equals(end)) {
                path.add(current);
                while (!current.equals(start)) {
                    path.add(parentMap.get(current));
                    current = parentMap.get(current);
                }
                Collections.reverse(path);
                break;
            }
            for (Coordinate direction : directions) {
                Coordinate neighbor =
                    new Coordinate(current.row() + direction.row(),
                        current.col() + direction.col());
                if (isValid(neighbor, maze) && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        return path;
    }

    private boolean isValid(Coordinate coordinate, Maze maze) {
        int row = coordinate.row();
        int col = coordinate.col();
        return row >= 0 && row < maze.getHeight()
            && col >= 0 && col < maze.getWidth()
            && maze.getGrid()[row][col].type() == Cell.Type.PASSAGE;
    }
}
