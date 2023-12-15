/**
 *This class contains methods used to validate user input for the Finnish personal ID (henkilötunnus), names, phone numbers, e-mail addresses and physical addresses.
 *
 * @author Eero Kiili
 */

import java.io.Console;
import java.util.ArrayList;

public class Validate {
    /**
     * An ArrayList containing all used personal IDs
     */
    public static ArrayList<String> knownIDs = new ArrayList<String>();
    
    /**
     * An ArrayList containing all used phone numbers
     */
    public static ArrayList<String> knownPhoneNums = new ArrayList<String>();

    /**
     * An ArrayList containing all used email addresses
     */
    public static ArrayList<String> knownEmails = new ArrayList<String>();

    /**
     * Checks if a string matches the pattern for a Finnish personal ID
     * and if the personal ID has already been entered for another contact.
     *
     * @param personalID a String containing a personal ID
     * @return {@code true} if the input matches the pattern and is not a duplicate, 
     * else {@code false}
     */
    public static boolean personalID(final String personalID) {
        for (String knownID : knownIDs) {
            if (knownID.equals(personalID)) {
                System.out.println("ID already in use.");
                return false;
            }
        }
        knownIDs.add(personalID);
        if (personalID.matches("^\\d{6}[-+A]\\d{3}[0-9A-FHJKLMNP-YZ]$")) {
            return true;
        }
        System.out.println("ID is not valid.");
        return false;
    }

    /**
     * Checks if a string matches the pattern for a name.
     *
     * @param name a String containing a name
     * @return {@code true} if the input matches the pattern, else {@code false}
     */
    public static boolean name(final String name) {
        return name.matches("^[A-ZÅÄÖ][a-zåäöA-ZÅÄÖ-]+$");
    }

    /**
     * Checks if a string matches the pattern for a phone number
     * and if the phone number has already been entered for another contact.
     *
     * @param phoneNum a String containing a phone number
     * @return {@code true} if the input matches the pattern and is not a duplicate, 
     * else {@code false}
     */
    public static boolean phoneNum(final String phoneNum) {
        for (String knownPhoneNum : knownPhoneNums) {
            if (knownPhoneNum.equals(phoneNum)) {
                System.out.println("Phone number already in use.");
                return false;
            }
        }
        knownPhoneNums.add(phoneNum);
        if (phoneNum.matches("^(\\+\\d{3}|0)\\d{9}$")) {
            return true;
        }
        System.out.println("Phone number is not valid.");
        return false;
    }

    /**
     * Checks if a string matches the pattern for an email address.
     * and if the email address has already been entered for another contact
     *
     * @param email a String containing an email address
     * @return {@code true} if the input matches the pattern and it is not a duplicate, 
     * else {@code false}
     */
    public static boolean email(final String email) {
        for (String knownEmail : knownEmails) {
            if (knownEmail.equals(email)) {
                System.out.println("Email address already in use.");
                return false;
            }
        }
        knownEmails.add(email);
        if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return true;
        }
        System.out.println("Email address is not valid.");
        return false;
    }

    /**
     * Checks if a string containing an address meets minimum length requirements.
     *
     * @param address a String containing an address
     * @return {@code true} if the address length is greater than or equal to 3, else {@code false}
     */
    public static boolean address(final String address) {
        return address.length() >= 3;
    }

    /**
     * Validates user input when program is expecting an integer.
     * 
     * @param min the minimum value that is accepted
     * @param max the maximum value that is accepted
     * @return a valid integer input
     */
    public static int answerNumber(int min, int max) {
        Console console = System.console();
        int answer = 0;
        boolean validInput = false;
        do {
            try {
                System.out.printf("\nChoose a number %d-%d to get started: ", min, max);
                String input = console.readLine();
                answer = Integer.parseInt(input);
                if (answer >= min && answer <= max) {
                    validInput = true;
                } else {
                    System.out.printf("\nPlease enter a number between %d and %d.", min, max);
                }
            //Catches an exception if user tries inputting anything but a number
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!validInput);
        return answer;
    }
}
