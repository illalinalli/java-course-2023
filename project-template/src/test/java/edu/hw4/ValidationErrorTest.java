package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class ValidationErrorTest {
    @Test
    public void testPrettyValidateAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 15, 30, 50, true));
        animals.add(new Animal("", Animal.Type.BIRD, Animal.Sex.M,-1, -2, -150, false));
        animals.add(new Animal("Pocco", Animal.Type.DOG, Animal.Sex.F,10, 3, 5000, true));
        Map<String, String> errors = ValidationError.PrettyValidateAnimals(animals);
        assertEquals(1, errors.size());
        assertFalse(errors.containsKey("Lion"));
        assertTrue(errors.containsKey(""));

        String lionErrors = errors.get("Lion");
        assertEquals(null, lionErrors);

        String emptyErrors = errors.get("");
        assertEquals("Name cannot be empty. Age cannot be negative. Height cannot be negative. Weight cannot be negative. ", emptyErrors);
    }
}
