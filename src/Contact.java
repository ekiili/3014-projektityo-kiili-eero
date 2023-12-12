/**
 * This class is used for managing contacts.
 * It features getters and setters for each attribute a contact can have
 * and methods for writing, reading and managing text files.
 * 
 * @author Eero Kiili
 */
import java.io.Console;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Contact {
    static Console console = System.console();

    /**
     * An ArrayList that contains every Contact object.
     */
    public static ArrayList<Contact> contactList = new ArrayList<>();

    public static boolean contactsExist = false;

    /**
     * Sets the width for the box the contacts are displayed in.
     */
    public static int boxWidth = 25;

    private static String boxBorder = "| ------------ | " + "-".repeat(boxWidth) + " |\n";
    private String personalID;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;
    private String email;
    
    /**
     * Forces every new contact to have a personal ID, first name,
     * last name and phone number. Address and e-mail are not set at this point.
     */
    public Contact() {
        setPersonalID();
        setFirstName();
        setLastName();
        setPhoneNum();
        this.address = "No address set";
        this.email = "No e-mail address set";
    }

    /**
     * Creates a contact and sets attribute values from pre-existing information.
     * Used by loadContact() every time the program starts.
     */
    public Contact(String tempID, String tempFirstName, String tempLastName, 
                    String tempPhoneNum, String tempAddress, String tempEmail) {
        this.personalID = tempID;
        this.firstName = tempFirstName;
        this.lastName = tempLastName;
        this.phoneNum = tempPhoneNum;
        this.address = tempAddress;
        this.email = tempEmail;
    }

    /**
     * Takes input from console and checks if it matches the pattern of a personal ID.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setPersonalID() {
        System.out.print("Set personal ID: ");
        String tempID = console.readLine();
        //Validates input
        if (!(Validate.personalID(tempID))) {
            System.out.println("ID is not valid.");
            setPersonalID();
        } else {
            this.personalID = tempID;
        }
    }

    /**
     * Returns the personal ID of the contact.
     *
     * @return the personal ID of the contact
     */
    public String getPersonalID() {
            return this.personalID;
    }

    /**
     * Takes input from console and checks if it matches the pattern of a name.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setFirstName() {
        System.out.print("Set first name: ");
        String tempFirstName = console.readLine();
        //Validates input
        if (!(Validate.name(tempFirstName))) {
            System.out.println("Name is not valid.");
            setFirstName();
        } else {
            this.firstName = tempFirstName;
        }
    }

    /**
     * Returns the first name of the contact.
     *
     * @return the first name of the contact
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Takes input from console and checks if it matches the pattern of a name.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setLastName() {
        System.out.print("Set last name: ");
        String tempLastName = console.readLine();
        //Validates input
        if (!(Validate.name(tempLastName))) {
            System.out.println("Name is not valid.");
            setLastName();
        } else {
            this.lastName = tempLastName;
        }
    }

    /**
     * Returns the last name of the contact.
     *
     * @return the last name of the contact
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Takes input from console and checks if it matches the pattern of a phone number.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setPhoneNum() {
        System.out.print("Set phone number: ");
        String tempPhoneNum = console.readLine();
        //Validates input
        if (!(Validate.phoneNum(tempPhoneNum))) {
            System.out.println("Phone number is not valid.");
            setPhoneNum();
        } else {
            this.phoneNum = tempPhoneNum;
        }
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return the phone number of the contact
     */
    public String getPhoneNum() {
        return this.phoneNum;
    }

    /**
     * Takes input from console and checks if it matches the pattern of an address.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setAddress() {
        System.out.print("Set address: ");
        String tempAddress = console.readLine();
        //Validates input
        if (!(Validate.address(tempAddress))) {
            System.out.println("Address is not valid.");
            setAddress();
        } else {
            this.address = tempAddress;
        }
    }

    /**
     * Returns the address of the contact.
     *
     * @return the address of the contact
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Takes input from console and checks if it matches the pattern of an e-mail address.
     * If input is invalid, it calls itself again to retry. If input is valid, it sets the input to the attribute.
     */
    public void setEmail() {
        System.out.print("Set e-mail address: ");
        String tempEmail = console.readLine();
        //Validates input
        if (!(Validate.email(tempEmail))) {
            System.out.println("E-mail address is not valid.");
            setEmail();
        } else {
            this.email = tempEmail;
        }
    }

    /**
     * Returns the email address of the contact.
     *
     * @return the email address of the contact
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Adds all the attributes of a contact in a box format into a single string.
     * 
     * @return a string that contains all the information of a contact
     */
    public String info() {
        String info =   "| personal ID  | " + formatInfo(getPersonalID()) +
                        "| first name   | " + formatInfo(getFirstName()) +
                        "| last name    | " + formatInfo(getLastName()) +
                        "| phone number | " + formatInfo(getPhoneNum()) +
                        "| address      | " + formatInfo(getAddress()) +
                        "| e-mail       | " + formatInfo(getEmail()) +
                        boxBorder;
        return info;
    }

    /**
     * Formats text to fit into a box with a set width.
     * 
     * @param text a string that gets formatted to fit into the box
     * @return the string "text" with added spaces and a border for the box
     */
    public String formatInfo(String text) {
        int space = boxWidth - text.length();
        String line = text + " ".repeat(space) + " |\n";
        return line;
    }

    /**
     * Adds all the attributes of a contact into a single string.
     * 
     * @return a string that contains all the information of a contact
     */
    public String data() {
        String data = getPersonalID() + ",\n"
                    + getFirstName()  + ",\n"
                    + getLastName()   + ",\n"
                    + getPhoneNum()   + ",\n"
                    + getAddress()    + ",\n"
                    + getEmail()      + "\n;\n";
        return data;
    }

    /**
     * Writes text to a file using BufferedWriter and FileWriter.
     * Writes the raw data to one file 
     * and the list that is displayed to the user to another file.
     * 
     * @param contact the contact which has its attributes written to the file
     */
    public static void write(Contact contact) {
        try (BufferedWriter infoWriter = new BufferedWriter(new FileWriter(ContactsApp.displayFileName, true));
            BufferedWriter dataWriter = new BufferedWriter(new FileWriter(ContactsApp.dataFileName, true))) {
            if (!(contactsExist)) {
                //If there is no contacts, write the top border of the box before writing contact information
                infoWriter.write(boxBorder);
                contactsExist = true;
            }
            infoWriter.write(contact.info());
            dataWriter.write(contact.data());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the contents of contactList to a file file using BufferedWriter and FileWriter
     * overwriting previous contents of the file.
     */
    public static void reWriteList() {
        try (BufferedWriter infoWriter = new BufferedWriter(new FileWriter(ContactsApp.displayFileName));
            BufferedWriter dataWriter = new BufferedWriter(new FileWriter(ContactsApp.dataFileName))) {
            infoWriter.write(boxBorder); //Writes the top border of the box

            //Iterates through the contactList and writes the info and data of every contact
            for (Contact contact : contactList) {
                infoWriter.write(contact.info());
                dataWriter.write(contact.data());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads text from a file using BufferedReader and FileReader,
     * then prints it to the console one line at a time.
     */
    public static void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ContactsApp.displayFileName))) {
            String line;
            //As long as there is text to read, print it to the console
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Iterates through the contactList (an ArrayList) to find the specific index 
     * where the contacts personal ID attribute is equal to the input.
     * If the method does not find a match, it asks the user to either retry,
     * view contacts to check every contacts ID or exit to menu.
     * 
     * @return the index of the matching contact if match is found
     */
    public static int find() {
        System.out.print("\nEnter the personal ID of the contact: ");
        String idInput = console.readLine();
        //Iterates through the contactList
        for (int i = 0; i <= contactList.size(); i++) {
            //If the input matches the personal ID of any contact, return the index
            if (contactList.get(i).getPersonalID().equals(idInput)) {
                return i;
            }
        }
        System.out.println("\nContact not found.\n");

        System.out.println("Choose an option:\n1. Retry\n2. View contacts\n3. Exit to menu");
        //Validate input for the answer
        switch (Validate.answerNumber(1, 3)) {
            case 1:
                find();
                break;
            case 2:
                read();
                break;
            case 3:
                ContactsApp.menu();
                break;
        }
        return -1;  //The program will never get here, but there must be a return statement here...
    }

    /**
     * Reads the data file that contains every contact
     * and adds them to a single string per contact that is then split into attributes
     * and created into a contact by the toContact method.
     * This method is called first every time the program starts.
     */
    public static void loadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ContactsApp.dataFileName))) {
            String line;
            String allLines = "";
            while ((line = reader.readLine()) != null) {
                //Adds every line to one string
                allLines += line;
                if (line.equals(";")) {
                    //When the reader reaches ;
                    //-> Sends all information read to toContact 
                    //and resets allLines to empty
                    contactList.add(toContact(allLines));
                    allLines = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Splits a string into parts and assigns them as attributes to a contact.
     * 
     * @param allLines a string that contains data about a contact
     * @return a new contact that has all its attributes set.
     */
    public static Contact toContact(String allLines) {
        //Splits allLines to six separate strings and puts them into an array
        String[] parts = allLines.split(",");
        return new Contact(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }
}
