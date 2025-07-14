package com.uday.contactBook;

public class Contact {
	// These are the attributes of a contact. They are 'private' to protect the data (Encapsulation).
    private String name;
    private String phoneNumber;
    private String email;

    // This is the constructor. It's called when you create a new Contact object.
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // These are "getter" methods. They allow other classes to read the private attributes.
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // This method provides a nice, readable string representation of the contact.
    // It's automatically called when you try to print a Contact object.
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
