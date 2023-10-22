package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {
    @Test
    public void rectangleAreaTestCorrectAnswer() {
        Rectangle rectangle = new Rectangle(10, 20);
        assertEquals(200, rectangle.area());
    }

    @Test
    public void squareAreaTestCorrectAnswerAfterChangingWidth() {
        Rectangle square = new Square(5);
        square = square.setWidth(70);
        assertEquals(4900, square.area());
    }
    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(5, 10);
        double expectedArea = 50.0;
        double actualArea = rectangle.area();
        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    public void testSquareArea() {
        Square square = new Square(5);
        double expectedArea = 25.0;
        double actualArea = square.area();
        assertEquals(expectedArea, actualArea, 0.001);
    }

}
