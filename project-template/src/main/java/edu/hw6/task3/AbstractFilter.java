package edu.hw6.task3;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    // Реализация метода and для объединения фильтров
    default AbstractFilter and(AbstractFilter filter) {
        return entry -> this.accept(entry) && filter.accept(entry);
    }

}
