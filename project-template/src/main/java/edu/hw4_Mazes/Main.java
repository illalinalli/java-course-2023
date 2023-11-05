package edu.hw4_Mazes;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] vargs) {
        int height = 10;
        int width = 10;
        Generator generator = new DepthFirstGenerator(new Random());
        Maze maze = generator.generate(height, width);
        System.out.println("Вывод сгенерированного лабиринта:");
        System.out.println();
        System.out.println(new ConsoleRenderer().render(maze));
        // даем право пользователю вводить начало и конец пути
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВНИМАНИЕ! Нумерация координат начинается с 0. ");
        System.out.print("Введите координату x1: ");
        int x1 = scanner.nextInt();
        System.out.print("Введите координату y1: ");
        int y1 = scanner.nextInt();
        Coordinate start = new Coordinate(x1, y1);

        System.out.print("Введите координату x2: ");
        int x2 = scanner.nextInt();
        System.out.print("Введите координату y2: ");
        int y2 = scanner.nextInt();
        Coordinate end = new Coordinate(x2, y2);

        System.out.println("Старт в точке: (" + start.row() + ", " + start.col() + ")");
        System.out.println("Конец в точке: (" + end.row() + ", " + end.col() + ")");
        Solver solver = new DepthFirstSolver();
        List<Coordinate> path = solver.solve(maze, start, end);
        System.out.println();
        System.out.println("Вывод пути в лабиринте:");
        if (path.size() != 0) {
            System.out.println(new ConsoleRenderer().render(maze, path));
        }
        else {
            System.out.println("Такого пути не существует. Попадание в стену.");
        }
    }
}
