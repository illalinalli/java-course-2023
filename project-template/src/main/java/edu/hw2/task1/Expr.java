package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double expr) implements Expr {
        @Override
        public double evaluate() {
            return expr;
        }
    }

    record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate(){
            return  -expr.evaluate();
        }
    }
    record Exponent(Expr base, Expr power) implements Expr {
        @Override
        public double evaluate(){
            return Math.pow(base.evaluate(), power.evaluate());
        }
    }
    record Addition(Expr op1, Expr op2) implements Expr {

        @Override
        public double evaluate(){
            return op1.evaluate() + op2.evaluate();
        }
    }
    record Multiplication(Expr op1, Expr op2) implements Expr {

        @Override
        public double evaluate(){
            return op1.evaluate() * op2.evaluate();
        }

    }
}
