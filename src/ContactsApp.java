/**
 * This is the main class that handles the application logic and user interaction.
 * 
 * @author Eero Kiili
 */

import java.io.Console;
import java.util.ArrayList;

public class ContactsApp {
    public static final String displayFileName = "contacts.txt";
    public static final String dataFileName = "contactData.txt";
    static Console console = System.console();
    /**
     * The main method that runs the program.
     * 
     * @param args -not used
     */
    public static void main(final String[] args) {
        //Reads contactData.txt and creates an ArrayList from the contacts
        Contact.loadFile();
        //If there are contacts, sets contactsExist to true
        if (Contact.contactList.size() > 0) {
            Contact.contactsExist = true;
        }
        //If there is nothing else happening, display the menu
        while (true) {
            menu();
        }
    }

    /**
     * Lets the user navigate through ContactsApp
     */
    public static void menu() {
        System.out.print("\n\nChoose an option:\n\n1. Create a new contact\n2. View contacts\n"
                        + "3. Update a contact\n4. Delete a contact\n5. Exit\n");
        //Validate input for the answer
        switch (Validate.answerNumber(1, 5)) {
            case 1:
                createContact();
                break;
            case 2:
                viewContact();
                break;
            case 3:
                updateContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                //Quits the program entirely
                System.exit(0);
        }
    }

    /**
     * Creates a new contact, adds it to the contactList
     * and writes its information to a file.
     */
    public static void createContact() {
        Contact.contactList.add(new Contact());
        //Sends the newest contact object to Contact.write()
        Contact.write(Contact.contactList.get(Contact.contactList.size() -1));
    }

    /**
     * Prints the information of every contact to the console.
     */
    public static void viewContact() {
        if (Contact.contactsExist) {
            System.out.println("You have " + (Contact.contactList.size()) + " contact(s).\n");
            Contact.read();
        } else {
            noContacts();
        }
    }

    /**
     * Updates a single attribute of a specific contact using the Contact.find method
     * then overwrites the text files with the new information.
     */
    public static void updateContact() {
        if (Contact.contactsExist) {
            //Finds the contactList index that the user wants to update
            int index = Contact.find();
            System.out.println("What would you like to update?\n1. Personal ID\n2. Name\n"
                            + "3. Phone number\n4. Address\n5. E-mail address\n6. Exit\n");
            //Validate input for the answer
            switch (Validate.answerNumber(1, 6)) {
                    case 1:
                        Contact.contactList.get(index).setPersonalID();
                        break;
                    case 2:
                        Contact.contactList.get(index).setFirstName();
                        Contact.contactList.get(index).setLastName();
                        break;
                    case 3:
                        Contact.contactList.get(index).setPhoneNum();
                        break;
                    case 4:
                        Contact.contactList.get(index).setAddress();
                        break;
                    case 5:
                        Contact.contactList.get(index).setEmail();
                        break;
                    case 6:
                        break;
            }
            //Rewrites the entire contacts.txt with the new updated information
            Contact.reWriteList();
        } else {
            noContacts();
        }
    }

    /**
     * Deletes contacts either by using the Contact.find method to delete a specific contact
     * or by deleting all contacts.
     */
    public static void deleteContact() {
        if (Contact.contactsExist) {
            System.out.println("Choose an option:\n1. Delete a single contact\n2. Delete all contacts\n3. Exit\n");
            //Validate input for the answer
            switch (Validate.answerNumber(1, 3)) {
                case 1:
                    Contact.contactList.remove(Contact.find());
                    System.out.println("\nContact deleted.");
                    break;
                case 2:
                    String choice;
                    do {
                        System.out.println("Are you sure? (Y/N)");
                        choice = console.readLine().toUpperCase();
                        switch (choice) {
                            case "Y":
                                //Empties contactList
                                Contact.contactList.clear();
                                System.out.println("\nAll contacts deleted.");
                                break;
                            case "N":
                                deleteContact();
                                break;
                        }
                    } while (!(choice.matches("[YN]")));
                case 3:
                    break;
            }
            if (Contact.contactList.size() == 0) {
                Contact.contactsExist = false;
            }
            //Rewrites the entire contacts.txt with the new updated information
            Contact.reWriteList();
        } else {
            noContacts();
        }
    }

    /**
     * Prints "You have no contacts." 
     * and adds a two second delay for clarity.
     */
    public static void noContacts() {
        System.out.println("\nYou have no contacts.\n\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
