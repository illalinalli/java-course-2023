package edu.hw3.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    public void testGetFullName() {
        Contact contact1 = new Contact("John", "Doe");
        assertEquals("John Doe", contact1.getFullName());

        Contact contact2 = new Contact("Jane", null);
        assertEquals("Jane", contact2.getFullName());

        Contact contact3 = new Contact("Bob", "");
        assertEquals("Bob", contact3.getFullName());
    }

    @Test
    public void testGetLastName() {
        Contact contact1 = new Contact("John", "Doe");
        assertEquals("Doe", contact1.getLastName());

        Contact contact2 = new Contact("Jane", null);
        assertEquals("Jane", contact2.getLastName());

        Contact contact3 = new Contact("Bob", "");
        assertEquals("Bob", contact3.getLastName());
    }

    @Test
    public void testParseContacts() {
        String[] names = {"John Doe", "Jane Smith", "Bob Johnson"};
        Contact[] contacts = Contact.parseContacts(names, "ASC");

        assertEquals("John Doe", contacts[0].getFullName());
        assertEquals("Bob Johnson", contacts[1].getFullName());
        assertEquals("Jane Smith", contacts[2].getFullName());

        contacts = Contact.parseContacts(names, "DESC");

        assertEquals("Jane Smith", contacts[0].getFullName());
        assertEquals("Bob Johnson", contacts[1].getFullName());
        assertEquals("John Doe", contacts[2].getFullName());

        names = new String[]{};
        contacts = Contact.parseContacts(names, "ASC");

        assertEquals(0, contacts.length);

        contacts = Contact.parseContacts(null, "ASC");

        assertEquals(0, contacts.length);
    }
}
