package edu.hw6.task2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class FileClonerTest {

    @Test
    public void testCloneFile() throws IOException {
        // Создаем временную директорию
        Path tempDir = Files.createTempDirectory("tempDir");

        // Создаем тестовый файл
        Path originalFile = Paths.get(tempDir.toString(), "test.txt");
        Files.write(originalFile, "Test Data".getBytes());

        // Клонируем файл
        FileCloner.cloneFile(originalFile);

        // Проверяем, что была создана копия файла
        File[] files = tempDir.toFile().listFiles();
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }
        assertTrue(Arrays.asList(fileNames).contains("test — копия.txt"));
    }
    @Test
    public void testCloneFileWithMultipleDotsInExtension() throws IOException {
        // Создаем временную директорию
        Path tempDir = Files.createTempDirectory("tempDir");

        // Создаем тестовый файл
        Path originalFile = Paths.get(tempDir.toString(), "test.app.jar");
        Files.write(originalFile, "Test Data".getBytes());

        // Клонируем файл
        FileCloner.cloneFile(originalFile);

        // Проверяем, что была создана копия файла
        File[] files = tempDir.toFile().listFiles();
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }
        assertTrue(Arrays.asList(fileNames).contains("test.app — копия.jar"));

    }

}
