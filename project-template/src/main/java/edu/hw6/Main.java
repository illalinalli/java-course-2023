package edu.hw6;

import edu.hw6.task1.DiskMap;
import edu.hw6.task2.FileCloner;
import edu.hw6.task3.AbstractFilter;
import edu.hw6.task4.OutputStreamComposition;
import edu.hw6.task5.HackerNews;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import static edu.hw6.task3.Filter.globMatches;
import static edu.hw6.task3.Filter.largerThan;
import static edu.hw6.task3.Filter.magicNumber;
import static edu.hw6.task3.Filter.regexContains;
import static java.nio.file.Files.newDirectoryStream;

public class Main {

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;
    public static void main(String[] args) {
        // Task 1
        DiskMap diskMap = new DiskMap("myDiskMap.txt");

        // добавляем значения в карту
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.put("key3", "value3");

        // выводим значения карты
        System.out.println("Size: " + diskMap.size());
        System.out.println("Values: " + diskMap.values());

        // удаляем значение из карты
        diskMap.remove("key2");

        // выводим измененные значения карты
        System.out.println("Size: " + diskMap.size());
        System.out.println("Values: " + diskMap.values());

        // проверяем наличие ключа в карте
        if (diskMap.containsKey("key1")) {
            System.out.println("Value of key1: " + diskMap.get("key1"));
        }

        // очищаем карту
        diskMap.clear();

        // проверяем, что карта пуста
        if (diskMap.isEmpty()) {
            System.out.println("Disk map пустой.");
        }

        // Task 2
        Path filePath = Paths.get("C:\\Users\\Alina\\Homework_Java/DataForClone.txt");

        FileCloner.cloneFile(filePath);
        // task 4
        OutputStreamComposition writer = new OutputStreamComposition();
        writer.make("C:\\Users\\Alina\\Homework_Java/DataForClone.txt");

        // task 5
        HackerNews hn = new HackerNews();
        long[] topStories = HackerNews.hackerNewsTopStories();
        System.out.println(Arrays.toString(topStories));
        String newsTitle = HackerNews.news(37570037);
        System.out.println(newsTitle);

    }
}
