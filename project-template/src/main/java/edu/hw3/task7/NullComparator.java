package edu.hw3.task7;

import java.util.Comparator;

public class NullComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return Comparator.nullsFirst(
            Comparator.comparing(s -> (String) s)
        ).compare(o1, o2);
            //Comparator.nullsFirst(
            //Comparator.<String>comparing(s -> s)
        //);
       // return ((Comparable<T>) o1).compareTo(o2);
    }
}
