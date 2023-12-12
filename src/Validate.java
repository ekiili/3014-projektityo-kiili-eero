import java.io.Console;

/**
 *This class contains methods used to validate user input for the Finnish personal ID (henkilötunnus), names, phone numbers, e-mail addresses and physical addresses.
 *
 * @author Eero Kiili
 */

public class Validate {
    /**
     * Checks if a string matches the pattern for a Finnish personal ID.
     *
     * @param personalID a String containing a personal ID
     * @return {@code true} if the input matches the pattern, {@code false} otherwise
     */
    public static boolean personalID(final String personalID) {
        return personalID.matches("^\\d{6}[-+A]\\d{3}[0-9A-FHJKLMNP-YZ]$");
    }

    /**
     * Checks if a string matches the pattern for a name.
     *
     * @param name a String containing a name
     * @return {@code true} if the input matches the pattern, {@code false} otherwise
     */
    public static boolean name(final String name) {
        return name.matches("^[A-ZÅÄÖ][a-zåäöA-ZÅÄÖ-]+$");
    }

    /**
     * Checks if a string matches the pattern for a phone number.
     *
     * @param phoneNum a String containing a phone number
     * @return {@code true} if the input matches the pattern, {@code false} otherwise
     */
    public static boolean phoneNum(final String phoneNum) {
        return phoneNum.matches("^(\\+\\d{3}|0)\\d{9}$");
    }

    /**
     * Checks if a string matches the pattern for an email address.
     *
     * @param email a String containing an email address
     * @return {@code true} if the input matches the pattern, {@code false} otherwise
     */
    public static boolean email(final String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    /**
     * Checks if a string containing an address meets minimum length requirements.
     *
     * @param address a String containing an address
     * @return {@code true} if the address length is greater than or equal to 3, {@code false} otherwise
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
