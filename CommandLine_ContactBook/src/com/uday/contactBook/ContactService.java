package com.uday.contactBook;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ContactService {
	
	private static final String FILE_NAME = "contacts.txt";

	public void loadContactsFromFile() {
	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // We'll save contacts as "Name,PhoneNumber,Email"
	            String[] parts = line.split(",");
	            if (parts.length == 3) {
	                Contact contact = new Contact(parts[0], parts[1], parts[2]);
	                contacts.add(contact);
	            }
	        }
	    } catch (IOException e) {
	        // If the file doesn't exist yet, that's fine. We'll create it on save.
	        System.out.println("No existing contacts file found. Starting fresh.");
	    }
	}

	public void saveContactsToFile() {
	    // try-with-resources ensures the writer is automatically closed
	    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
	        for (Contact contact : contacts) {
	            // Write each contact as a comma-separated line
	            writer.println(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
	        }
	    } catch (IOException e) {
	        System.err.println("Error saving contacts: " + e.getMessage());
	    }
	}
	
	// A list to hold all the Contact objects. This is our in-memory "database".
    private List<Contact> contacts = new ArrayList<>();

    // Adds a new contact to the list.
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Returns the entire list of contacts.
    public List<Contact> getAllContacts() {
        return contacts;
    }
    
    // Searches for a contact by name (case-insensitive).
    public Contact findContactByName(String name) {
        // We loop through each contact in the list.
        for (Contact contact : contacts) {
            // If the name matches (ignoring case), we return that contact.
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        // If we finish the loop and find no match, we return null.
        return null; 
    }

    // Deletes a contact from the list.
    public boolean deleteContact(Contact contact) {
        // The remove() method returns true if the item was successfully removed.
        return contacts.remove(contact);
    }

}
