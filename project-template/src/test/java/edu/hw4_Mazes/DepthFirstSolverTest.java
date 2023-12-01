package edu.hw4_Mazes;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DepthFirstSolverTest {
    @Test
    public void testSolve() {
        Cell[][] grid = {
            {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.WALL), new Cell(0, 2, Cell.Type.WALL), new Cell(0, 3, Cell.Type.WALL), new Cell(0, 4, Cell.Type.WALL)},
            {new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.PASSAGE), new Cell(1, 3, Cell.Type.PASSAGE), new Cell(1, 4, Cell.Type.PASSAGE)},
            {new Cell(2, 0, Cell.Type.WALL), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.WALL), new Cell(2, 3, Cell.Type.PASSAGE), new Cell(2, 4, Cell.Type.WALL)},
            {new Cell(3, 0, Cell.Type.PASSAGE), new Cell(3, 1, Cell.Type.WALL), new Cell(3, 2, Cell.Type.PASSAGE), new Cell(3, 3, Cell.Type.PASSAGE), new Cell(3, 4, Cell.Type.PASSAGE)},
            {new Cell(4, 0, Cell.Type.PASSAGE), new Cell(4, 1, Cell.Type.WALL), new Cell(4, 2, Cell.Type.WALL), new Cell(4, 3, Cell.Type.WALL), new Cell(4, 4, Cell.Type.PASSAGE)}
        };
        Maze maze = new Maze(5, 5, grid);
        Coordinate start = new Coordinate(1, 0);
        Coordinate end = new Coordinate(4, 4);
        DepthFirstSolver solver = new DepthFirstSolver();
        List<Coordinate> path = solver.solve(maze, start, end);
        List<Coordinate> expectedPath = Arrays.asList(
            new Coordinate(1, 0),
            new Coordinate(1, 1),
            new Coordinate(1, 2),
            new Coordinate(1, 3),
            new Coordinate(2, 3),
            new Coordinate(3, 3),
            new Coordinate(3, 4),
            new Coordinate(4, 4)
        );
        assertEquals(expectedPath, path);
    }
}
