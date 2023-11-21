package edu.hw6.task4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class OutputStreamCompositionTest {
    @Test
    void testMake() throws IOException {
        // создаем инстанс класса OutputStreamComposition
        OutputStreamComposition outputStreamComposition = new OutputStreamComposition();

        // задаем временный файл для записи вывода
        String path = "C:\\Users\\Alina\\Homework_Java\\test.txt";

        // вызываем метод make() с временным файлом
        outputStreamComposition.make(path);

        // проверяем, что файл существует
        assertTrue(new File(path).exists(), "Файл не создан");

        // проверяем, что файл содержит ожидаемый текст
        String expectedText = "Programming is learned by writing programs. - Brian Kernighan";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        assertEquals(expectedText, line);

        // удаляем временный файл
        new File(path).delete();
    }
}
