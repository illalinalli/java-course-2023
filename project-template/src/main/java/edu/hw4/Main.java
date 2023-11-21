package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static edu.hw4.ValidationError.PrettyValidateAnimals;
import static edu.hw4.ValidationError.validateAnimals;

public class Main {
    public static void main(String[] vargs) {

        // Task 1 - Отсортировать животных по росту от самого маленького к самому большому
        System.out.println("Results of task 1 - Отсортировать животных по росту от самого маленького к самому большому:");
        // инициализация списка животных
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Fluffy", Animal.Type.CAT, Animal.Sex.M, 3, 25, 4, false));
        animals.add(new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 5, 30, 10, true));
        animals.add(new Animal("Tweety", Animal.Type.BIRD, Animal.Sex.F, 1, 5, 6, false));
        animals.add(new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, 2, 3, false));
        animals.add(new Animal("Charlotka", Animal.Type.SPIDER, Animal.Sex.F, 1, 2, 4, true));
        animals.sort(Comparator.comparingInt(Animal::height));
        for (var a: animals){
            System.out.println(a);
        }

        // Task 2 - Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых
        System.out.println("Results of task 2 - Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых:");
        int k = 3; // количество первых элементов, которые нужно выбрать
        List<Animal> heaviestAnimals = animals.stream()
            .sorted(Comparator.comparingInt((Animal a) -> -a.weight()))
            .limit(k)
            .toList();
        for (var a: heaviestAnimals) {
            System.out.println(a);
        }

        // Task 3 - Сколько животных каждого вида
        // добавим животное для разнообразия
        animals.add(new Animal("Petter", Animal.Type.FISH, Animal.Sex.M, 1, 4, 1, true));
        System.out.println("Results of task 3 - Сколько животных каждого вида:");
        Map<Animal.Type, Integer> countByType = animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(a -> 1)));
        countByType.forEach((key, value) -> System.out.println(key + ": " + value));

        // Task 4 - У какого животного самое длинное имя
        System.out.println("Result of task 4 - У какого животного самое длинное имя:");
        Animal animalWithLongestName = animals.stream()
            .max(Comparator.comparingInt(a -> a.name().length()))
            .get();
        System.out.println("The longest name: " + animalWithLongestName.name());

        // Task 5 - Каких животных больше: самцов или самок
        System.out.println("Results of task 5 - Каких животных больше: самцов или самок:");
        long malesCount = animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.M)
            .count();
        long femalesCount = animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.F)
            .count();
        if (malesCount > femalesCount) {
            System.out.println("Больше самцов");
        } else if (malesCount < femalesCount) {
            System.out.println("Больше самок");
        } else {
            System.out.println("Одинаковое количество самцов и самок");
        }

        // Task 6 - Самое тяжелое животное каждого вида
        // добавим ещё животных
        animals.add(new Animal("Dunya", Animal.Type.CAT, Animal.Sex.M, 14, 15, 7, false));
        animals.add(new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 10, 8, 20, true));
        animals.add(new Animal("Popka", Animal.Type.BIRD, Animal.Sex.F, 3, 3, 3, false));
        animals.add(new Animal("Olga", Animal.Type.FISH, Animal.Sex.F, 4, 4, 1, false));

        System.out.println("Results of task 6 - Самое тяжелое животное каждого вида:");
        Map<Animal.Type, Animal> heaviestAnimalsRes = animals.stream()
            .collect(Collectors.groupingBy(Animal::type,
                Collectors.maxBy(Comparator.comparingInt(Animal::weight))))
            .entrySet().stream()
            .filter(entry -> entry.getValue().isPresent())
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get())
            );

        for(var s: heaviestAnimalsRes.values()) {
            System.out.println(s);
        }

        // Task 7 - K-е самое старое животное
        k = 5;
        animals.sort(Comparator.comparingInt(Animal::age));
        System.out.println("Sorted animals (age) at list: ");
        for(var s: animals) {
            System.out.println(s);
        }
        Animal kthOldestAnimal = animals.get(k - 1);
        System.out.println("Results of task 7 - K-е самое старое животное:");
        System.out.println(kthOldestAnimal);

        // Task 8 - Самое тяжелое животное среди животных ниже k см
        int maxHeight = 15;
        Optional<Animal> heaviestAnimalBelowMaxHeight = animals.stream()
            .filter(animal -> animal.height() < maxHeight)
            .max(Comparator.comparingInt(Animal::weight));
        System.out.println("Results of task 8 - Самое тяжелое животное среди животных ниже k см:");
        System.out.println(heaviestAnimalBelowMaxHeight);

        // Task 9 - Сколько в сумме лап у животных в списке
        int totalPaws = animals.stream()
            .mapToInt(Animal::paws)
            .sum();
        System.out.println("Results of task 9 - Сколько в сумме лап у животных в списке:");
        System.out.println(totalPaws);

        // Task 10 - Список животных, возраст у которых не совпадает с количеством лап
        List<Animal> mismatchedAgeAndPawsAnimals = animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
        System.out.println("Results of task 10 - Список животных, возраст у которых не совпадает с количеством лап:");
        for (var a : mismatchedAgeAndPawsAnimals) {
            System.out.println(a);
        }

        // Task 11 - Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см
        System.out.println("Results of task 11 - " +
            "Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см:");
        List<Animal> result = animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
        if (result.size() > 0) {
            for (var a : result) {
                System.out.println(a);
            }
        }
       else {
           System.out.println("Таких животных нет.");
       }

       // Task 12 - Сколько в списке животных, вес которых превышает рост
        System.out.println("Results of task 12 - " +
            "Сколько в списке животных, вес которых превышает рост:");
        long count = animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
        Integer res = Math.toIntExact(count);
        System.out.println(res);

        // Task 13 - Список животных, имена которых состоят из более чем двух слов
        System.out.println("Results of task 13 - " +
            "Список животных, имена которых состоят из более чем двух слов:");
        List<Animal> animalsRes = animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
        if (animalsRes.size() > 0) {
            for (var a: animalsRes)
            {
                System.out.println(a);
            }
        }
        else {
            System.out.println("Таких животных нет.");
        }

        // Task 14 - Есть ли в списке собака ростом более k см
        System.out.println("Results of task 14 - Есть ли в списке собака ростом более k см");
        var height = 10; // заданный рост
        boolean isExists = animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > height);
        if (isExists) {
            System.out.println("Есть.");
        }
        else {
            System.out.println("Нет такого животного.");
        }

        // Task 15 - Найти суммарный вес животных каждого вида, которым от k до l лет
        System.out.println("Results of task 15 - Найти суммарный вес животных каждого вида, которым от k до l лет");
        int minAge = 2; // минимальный возраст
        int maxAge = 7; // максимальный возраст
        Map<Animal.Type, Integer> totalAge = animals.stream()
            .filter(animal -> animal.age() >= minAge && animal.age() <= maxAge)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
       for (var a: totalAge.values()) {
           System.out.println(a);
       }

       // Task 16 - Список животных, отсортированный по виду, затем по полу, затем по имени
        System.out.println("Results of task 16 - Список животных, отсортированный по виду, затем по полу, затем по имени");

        Comparator<Animal> animalComparator = Comparator
            .comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name);

       animals.sort(animalComparator);
        for (var a: animals) {
            System.out.println(a);
        }

        // Task 17 - Правда ли, что пауки кусаются чаще, чем собаки
        System.out.println("Results of task 17 - Правда ли, что пауки кусаются чаще, чем собаки:");
        long spiderBites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .filter(Animal::bites)
            .count();
        long dogBites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .filter(Animal::bites)
            .count();
        boolean spidersBiteMore = spiderBites > dogBites;
        System.out.println(spidersBiteMore);
        // Task 18 - Найти самую тяжелую рыбку в 2-х или более списках
        System.out.println("Results of task 18 - Найти самую тяжелую рыбку в 2-х или более списках:");
        List<Animal> animals2 = new ArrayList<>();
        animals.add(new Animal("Cactus", Animal.Type.CAT, Animal.Sex.M, 3, 12, 4, false));
        animals.add(new Animal("Baton", Animal.Type.FISH, Animal.Sex.M, 6, 3, 9, false));
        animals.add(new Animal("Gogga", Animal.Type.FISH, Animal.Sex.F, 8, 5, 15, false));
        List<List<Animal>> animalLists = List.of(animals, animals2);
        Optional<Animal> heaviestFish = animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight));
        System.out.println(heaviestFish);
        // Task 19
        System.out.println("Results of task 19:");
        List<Animal> animals3 = new ArrayList<>();
        animals3.add(new Animal("Tom", Animal.Type.CAT, Animal.Sex.M, 3, 25, 4, false));
        animals3.add(new Animal("", Animal.Type.DOG, Animal.Sex.F, -1, 30, 10, true));
        animals3.add(new Animal("Tweety", Animal.Type.BIRD, null, 1, 5, 0, false));
        animals3.add(new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 2, 10, 1, false));
        animals3.add(new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 0, false));
        Map<String, Set<ValidationError>> errors = validateAnimals(animals3);
        for (Map.Entry<String, Set<ValidationError>> entry : errors.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            if (entry.getValue().size() > 0) {
                for (var v : entry.getValue()) {
                    System.out.print(v.getMessage() + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("There are no errors.");
            }
        }
        // Task 20
        System.out.println("Results of task 20:");
        Map<String, String> errors2 = PrettyValidateAnimals(animals3);
        for (Map.Entry<String, String> entry : errors2.entrySet()) {
            System.out.println("Errors for animal " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
