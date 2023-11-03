package edu.hw3.task5;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Comparator;
public class Contact {
    private final String firstName;
    private final String lastName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        if (lastName == null || lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            return firstName;
        }
        return lastName;
    }

    public static Contact[] parseContacts(String[] names, String sortOrder) {
        if (names == null || names.length == 0) {
            return new Contact[0];
        }

        Comparator<Contact> comparator = Comparator.comparing(Contact::getLastName);
        if ("DESC".equals(sortOrder)) {
            comparator = comparator.reversed();
        }

        Contact[] contacts = Arrays.stream(names)
            .map(name -> {
                String[] parts = name.split(" ");
                String firstName = parts[0];
                String lastName = "";
                if (parts.length > 1) {
                    lastName = parts[parts.length - 1];
                }
                return new Contact(firstName, lastName);
            })
            .sorted(comparator)
            .toArray(Contact[]::new);

        Arrays.stream(contacts)
            .map(Contact::getFullName)
            .forEach(System.out::println);

        return contacts;
    }
}

