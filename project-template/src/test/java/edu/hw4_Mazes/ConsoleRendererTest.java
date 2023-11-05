package edu.hw4_Mazes;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleRendererTest {
    @Test
    public void testRender() {
        Cell[][] grid = new Cell[][] {
            { new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.PASSAGE) },
            { new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.WALL) }
        };
        Maze maze = new Maze(2, 2, grid);
        Renderer renderer = new ConsoleRenderer();
        String expected = "█ \n" +
            " █\n";
        assertEquals(expected, renderer.render(maze));
    }

    @Test
    public void testRenderWithPath() {
        Cell[][] grid = new Cell[][] {
            { new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.PASSAGE) },
            { new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE) }
        };
        Maze maze = new Maze(2, 2, grid);
        List<Coordinate> path = List.of(new Coordinate(0, 1), new Coordinate(1, 1));
        Renderer renderer = new ConsoleRenderer();
        String expected = "█*\n" +
            " *\n";
        assertEquals(expected, renderer.render(maze, path));
    }
}
