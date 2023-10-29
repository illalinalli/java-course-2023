package edu.hw3;

import edu.hw3.task2.Сlusterize;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarketImpl;
import edu.hw3.task7.NullComparator;
import edu.hw3.task8.BackwardIterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static edu.hw3.task5.Contact.parseContacts;

public class Main {

    // Task 1
    public static String atbash(String input) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)
                && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                output.append((char) (base + 25 - (c - base)));
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    // Task 3
    public static Map<Object, Integer> getFrequencyDictionary(List<Object> list) {
        Map<Object, Integer> freqDict = new HashMap<>();
        for (Object obj : list) {
            freqDict.put(obj, freqDict.getOrDefault(obj, 0) + 1);
        }
        return freqDict;
    }

    // Task 4
    public static String convertToRoman(int number) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number - arabicNumbers[i] >= 0) {
                result.append(romanNumerals[i]);
                number -= arabicNumbers[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] vargs) {
        // Task 1 - Шифр Атбаш
        System.out.println("Results Task 1:");
        System.out.println(atbash(
            "Any куРиНаЯ грудка can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"));

        // Task 2 - Скобочки
        System.out.println("Results Task 2:");
        List<String> res1 = Сlusterize.clusterize("()()()");
        System.out.println(res1);

        List<String> res2 = Сlusterize.clusterize("((()))");
        System.out.println(res2);

        List<String> res3 = Сlusterize.clusterize("((()))(())()()(()())");
        System.out.println(res3);

        List<String> res4 = Сlusterize.clusterize("((())())(()(()()))");
        System.out.println(res4);

        // Task 3 - Частота слов
        System.out.println("Results Task 3:");
        List<Object> list = Arrays.asList(1, 1, 2, 2);
        Map<Object, Integer> freqDict = getFrequencyDictionary(list);
        System.out.println(freqDict);

        // Task 4 - Римские цифры
        System.out.println("Results Task 4:");
        System.out.println(convertToRoman(2)); // "II"
        System.out.println(convertToRoman(12)); // "XII"
        System.out.println(convertToRoman(16)); // "XVI"

        // Task 5 - Список контактов
        System.out.println("Result Task 5:");
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        System.out.println("Result 5.1:");
        parseContacts(names, "ASC");

        names = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss", "Antonio", "Pablo"};
        System.out.println("Result 5.2:");
        parseContacts(names, "DESC");

        names = new String[] {};
        System.out.println("Result 5.3:");
        parseContacts(names, "DESC");

        System.out.println("Result 5.4:");
        parseContacts(null, "DESC");

        //Task 6 - Биржа
        System.out.println("Result Task 6:");
        Stock stock1 = new Stock("Apple", 150.0);
        Stock stock2 = new Stock("Microsoft", 200.0);
        Stock stock3 = new Stock("Amazon", 300.0);

        StockMarketImpl stockMarket = new StockMarketImpl();

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        System.out.println(stockMarket.mostValuableStock().getName());

        stockMarket.remove(stock3);

        System.out.println(stockMarket.mostValuableStock().getName());

        stock2.setPrice(250.0);

        System.out.println(stockMarket.mostValuableStock().getName());

        //Task 8 - Обратный итератор
        System.out.println("Result Task 8:");
        List<Integer> numbs = List.of(1, 2, 3);
        Iterator<Integer> iterator = new BackwardIterator<>(numbs);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

