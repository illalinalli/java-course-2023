package edu.hw6.task4;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class OutputStreamComposition {
    public void make(String path) {
        // создаем файл и получаем из него OutputStream
        try (OutputStream fileOutputStream = Files.newOutputStream(Paths.get(path))) {
            // добавляем CheckedOutputStream для проверки записи при помощи контрольной суммы
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());

            // добавляем BufferedOutputStream для буферизации данных
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            // добавляем OutputStreamWriter для работы с символами и кодировкой UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);

            // добавляем PrintWriter для записи текста
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            // записываем текст в файл
            printWriter.println("Programming is learned by writing programs. - Brian Kernighan");

            // закрываем ресурсы в обратном порядке
            printWriter.close();
            outputStreamWriter.close();
            bufferedOutputStream.close();
            checkedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

