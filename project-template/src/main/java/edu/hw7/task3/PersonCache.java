package edu.hw7.task3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonCache implements PersonDatabase {

    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (person != null) {
            personMap.put(person.id(), person);
            addToIndex(nameIndex, person.name(), person.id());
            addToIndex(addressIndex, person.address(), person.id());
            addToIndex(phoneIndex, person.phoneNumber(), person.id());
        }
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            removeFromIndex(nameIndex, person.name(), id);
            removeFromIndex(addressIndex, person.address(), id);
            removeFromIndex(phoneIndex, person.phoneNumber(), id);
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        Set<Integer> idSet = nameIndex.get(name);
        return (idSet != null) ? query(idSet) : Collections.emptyList();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        Set<Integer> idSet = addressIndex.get(address);
        return (idSet != null) ? query(idSet) : Collections.emptyList();
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        Set<Integer> idSet = phoneIndex.get(phone);
        return (idSet != null) ? query(idSet) : Collections.emptyList();
    }

    private void addToIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new HashSet<>()).add(id);
    }

    private void removeFromIndex(Map<String, Set<Integer>> index, String key, int id) {
        Set<Integer> idSet = index.get(key);
        if (idSet != null) {
            idSet.remove(id);
            if (idSet.isEmpty()) {
                index.remove(key);
            }
        }
    }

    private List<Person> query(Set<Integer> idSet) {
        return idSet.stream()
            .map(personMap::get)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}
