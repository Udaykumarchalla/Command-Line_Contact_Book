package com.uday.contactBook;
import java.util.List;
import java.util.Scanner;

public class UdaysContact {

	public static void main(String[] args) {
		
		// Create instances of our service and scanner
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);
        
        // Load contacts from file when the application starts
        contactService.loadContactsFromFile();

        // Main application loop
        while (true) {
            System.out.println("\n--- Personal Contact Book ---");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // This consumes the leftover newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactService.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.println("\n--- All Contacts ---");
                    List<Contact> allContacts = contactService.getAllContacts();
                    if (allContacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (Contact c : allContacts) {
                            System.out.println(c); // This automatically calls the toString() method
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the name to search for: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = contactService.findContactByName(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    Contact contactToDelete = contactService.findContactByName(deleteName);
                    if (contactToDelete != null) {
                        if (contactService.deleteContact(contactToDelete)) {
                            System.out.println("Contact deleted successfully.");
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    // Save contacts to file before exiting
                    contactService.saveContactsToFile(); 
                    
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
	}

}
