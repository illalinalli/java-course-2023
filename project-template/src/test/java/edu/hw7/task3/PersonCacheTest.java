package edu.hw7.task3;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonCacheTest {
    @Test
    void testAdd() {
        var cache = new PersonCache();
        Person person1 = new Person(1, "Alice", "123 Main St", "555-5555");
        Person person2 = new Person(2, "Bob", "456 Oak St", "555-1234");
        Person person3 = new Person(3, "Charlie", "789 Pine St", "555-7890");

        cache.add(person1);
        cache.add(person2);
        cache.add(person3);

        List<Person> peopleWithNameAlice = cache.findByName("Alice");
        assertEquals(1, peopleWithNameAlice.size());
        assertEquals(person1, peopleWithNameAlice.get(0));
    }

    @Test
    void testDelete() {
        var cache = new PersonCache();
        Person person1 = new Person(1, "Alice", "123 Main St", "555-5555");
        Person person2 = new Person(2, "Bob", "456 Oak St", "555-1234");

        cache.add(person1);
        cache.add(person2);

        cache.delete(person1.id());

        List<Person> peopleWithNameAlice = cache.findByName("Alice");
        assertEquals(Collections.emptyList(), peopleWithNameAlice);

        List<Person> peopleWithNameBob = cache.findByName("Bob");
        assertEquals(1, peopleWithNameBob.size());
        assertEquals(person2, peopleWithNameBob.get(0));
    }

    @Test
    void testFindByName() {
        var cache = new PersonCache();
        Person person1 = new Person(1, "Alice", "123 Main St", "555-5555");
        Person person2 = new Person(2, "Alice", "456 Oak St", "555-1234");

        cache.add(person1);
        cache.add(person2);

        List<Person> peopleWithNameAlice = cache.findByName("Alice");
        assertEquals(2, peopleWithNameAlice.size());
        assertTrue(peopleWithNameAlice.contains(person1));
        assertTrue(peopleWithNameAlice.contains(person2));
    }

    @Test
    void testFindByAddress() {
        var cache = new PersonCache();
        Person person1 = new Person(1, "Alice", "123 Main St", "555-5555");
        Person person2 = new Person(2, "Bob", "456 Oak St", "555-1234");

        cache.add(person1);
        cache.add(person2);

        List<Person> peopleWithAddress456Oak = cache.findByAddress("456 Oak St");
        assertEquals(1, peopleWithAddress456Oak.size());
        assertEquals(person2, peopleWithAddress456Oak.get(0));
    }

    @Test
    void testFindByPhone() {
        var cache = new PersonCache();
        Person person1 = new Person(1, "Alice", "123 Main St", "555-5555");
        Person person2 = new Person(2, "Bob", "456 Oak St", "555-1234");

        cache.add(person1);
        cache.add(person2);

        List<Person> peopleWithPhone5551234 = cache.findByPhone("555-1234");
        assertEquals(1, peopleWithPhone5551234.size());
        assertEquals(person2, peopleWithPhone5551234.get(0));
    }
}
