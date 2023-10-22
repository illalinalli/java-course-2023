package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExprTest {

    @Test
    public void testConstant() {
        Expr.Constant c = new Expr.Constant(5.0);
        assertEquals(5.0, c.evaluate());
    }

    @Test
    public void testNegate() {
        Expr.Constant c = new Expr.Constant(5.0);
        Expr.Negate n = new Expr.Negate(c);
        assertEquals(-5.0, n.evaluate());
    }

    @Test
    public void testExponent() {
        Expr.Constant c = new Expr.Constant(2.0);
        Expr.Exponent e = new Expr.Exponent(c, 3.0);
        assertEquals(8.0, e.evaluate());
    }

    @Test
    public void testAddition() {
        Expr.Constant c1 = new Expr.Constant(2.0);
        Expr.Constant c2 = new Expr.Constant(3.0);
        Expr.Addition a = new Expr.Addition(c1, c2);
        assertEquals(5.0, a.evaluate());
    }

    @Test
    public void testMultiplication() {
        Expr.Constant c1 = new Expr.Constant(2.0);
        Expr.Constant c2 = new Expr.Constant(3.0);
        Expr.Multiplication m = new Expr.Multiplication(c1, c2);
        assertEquals(6.0, m.evaluate());
    }
}
