package edu.hw6.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DiskMap implements Map<String, String>, Serializable {

    public final String filePath;
    public final Map<String, String> map = new HashMap<>();

    public DiskMap(String filePath) {
        this.filePath = filePath;
        load();
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                map.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Failed to load disk map from file: " + filePath);
        }
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Failed to save disk map to file: " + filePath);
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(String key, String value) {
        String oldValue = map.put(key, value);
        save();
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = map.remove(key);
        save();
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        map.putAll(m);
        save();
    }

    @Override
    public void clear() {
        map.clear();
        save();
    }

    @Override
    public java.util.Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public java.util.Collection<String> values() {
        return map.values();
    }

    @Override
    public java.util.Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
