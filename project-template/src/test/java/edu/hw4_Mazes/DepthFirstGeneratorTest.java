package edu.hw4_Mazes;

import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class DepthFirstGeneratorTest {
    @Test
    public void testGenerate() {
        Random random = new Random();
        Generator generator = new DepthFirstGenerator(random);
        Maze maze = generator.generate(10, 10);
        assertNotNull(maze);
        assertEquals(10, maze.getHeight());
        assertEquals(10, maze.getWidth());
        assertNotNull(maze.getCell(0, 0));
        assertNotNull(maze.getCell(9, 9));
        assertNotNull(maze.getCell(5, 5));
        assertEquals(Cell.Type.PASSAGE, maze.getCell(1, 1).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(3, 1).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(5, 1).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(7, 1).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(9, 1).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(1, 3).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(1, 5).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(1, 7).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(1, 9).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(3, 3).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(3, 5).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(3, 7).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(3, 9).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(5, 3).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(5, 5).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(5, 7).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(5, 9).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(7, 3).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(7, 5).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(7, 7).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(7, 9).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(9, 3).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(9, 5).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(9, 7).type());
        assertEquals(Cell.Type.PASSAGE, maze.getCell(9, 9).type());
    }
}
