/**
 *This class contains methods used to validate user input for the Finnish personal ID (henkilötunnus), names, phone numbers, e-mail addresses and physical addresses.
 *
 * @author Eero Kiili
 */

public class Validate {
    /**
     * Checks if a string matches the pattern for a Finnish personal ID.
     *
     * @param personalId a String containing a personal ID
     * @return {@code true} if the input matches the pattern, {@code false} otherwise
     */
    public static boolean personalId(final String personalId) {
        return personalId.matches("^\\d{6}[-+A]\\d{3}[0-9A-FHJKLMNP-YZ]$");
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
}
