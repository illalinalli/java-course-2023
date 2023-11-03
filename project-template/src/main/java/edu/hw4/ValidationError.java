package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationError {
    private final String message;

    public ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = new HashMap<>();
        for (Animal animal : animals) {
            Set<ValidationError> animalErrors = new HashSet<>();
            if (animal.name() == null || animal.name().isEmpty()) {
                animalErrors.add(new ValidationError("Name cannot be empty"));
            }
            if (animal.age() < 0) {
                animalErrors.add(new ValidationError("Age cannot be negative"));
            }
            if (animal.height() < 0) {
                animalErrors.add(new ValidationError("Height cannot be negative"));
            }
            if (animal.weight() < 0) {
                animalErrors.add(new ValidationError("Weight cannot be negative"));
            }
            if (animal.type() == null) {
                animalErrors.add(new ValidationError("Type cannot be null"));
            }
            if (animal.sex() == null) {
                animalErrors.add(new ValidationError("Sex cannot be null"));
            }
            errors.put(animal.name(), animalErrors);
        }
        return errors;
    }

    public static Map<String, String> PrettyValidateAnimals(List<Animal> animals) {
        Map<String, String> errors = new HashMap<>();
        for (Animal animal : animals) {
            StringBuilder animalErrors = new StringBuilder();
            if (animal.name() == null || animal.name().isEmpty()) {
                animalErrors.append("Name cannot be empty. ");
            }
            if (animal.age() < 0) {
                animalErrors.append("Age cannot be negative. ");
            }
            if (animal.height() < 0) {
                animalErrors.append("Height cannot be negative. ");
            }
            if (animal.weight() < 0) {
                animalErrors.append("Weight cannot be negative. ");
            }
            if (animal.type() == null) {
                animalErrors.append("Type cannot be null. ");
            }
            if (animal.sex() == null) {
                animalErrors.append("Sex cannot be null. ");
            }
            if (animalErrors.length() > 0) {
                errors.put(animal.name(), animalErrors.toString());
            }
        }
        return errors;
    }

}
