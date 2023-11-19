package edu.hw6.task2;
import java.nio.file.*;
import java.io.*;

public class FileCloner {
    public static void cloneFile(Path path) {
        Path parentDir = path.getParent();
        String fileName = path.getFileName().toString();
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        int copyIndex = 0;
        Path newFilePath;
        do {
            String copySuffix = (copyIndex == 0) ? " — копия" : " — копия (" + (copyIndex + 1) + ")";
            String newFileName = baseName + copySuffix + extension;
            newFilePath = Paths.get(parentDir.toString(), newFileName);
            copyIndex++;
        } while (Files.exists(newFilePath));
        try {
            Files.copy(path, newFilePath);
        } catch (IOException e) {
            System.out.println("Клонирование файла провалено: " + e);
        }
    }
}

