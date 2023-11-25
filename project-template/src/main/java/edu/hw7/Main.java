package edu.hw7;

import edu.hw7.task1.Counter;
import edu.hw7.task2.FactorialCalculator;
import edu.hw7.task3.Person;
import edu.hw7.task3.PersonCache;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // task 1
        Counter counter = new Counter();
        int numOfThreads = 10;
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numOfThreads; i++) {
            threads[i].join();
        }

        System.out.println("Counter value: " + counter.getCount());

        // task 2
        FactorialCalculator calculator = new FactorialCalculator();
        int num = 10;
        BigInteger result = calculator.factorial(num);

        System.out.println(num + "! = " + result.toString());

        // task 3
        PersonCache cache = new PersonCache();

        Person person1 = new Person(1, "John", "123 Main St", "123-456-7890");
        Person person2 = new Person(2, "Jane", "456 Elm St", "555-123-4567");
        Person person3 = new Person(3, "Bob", "789 Oak Ave", "777-888-9999");

        cache.add(person1);
        cache.add(person2);
        cache.add(person3);

        System.out.println(cache.findByName("John"));
        System.out.println(cache.findByAddress("456 Elm St"));
        System.out.println(cache.findByPhone("777-888-9999"));

        cache.delete(2);

        System.out.println(cache.findByName("Jane"));
    }
}
