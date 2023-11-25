/**
 * This class is used for creating and managing contacts.
 *
 * @author Eero Kiili
 */

public class Contact {
    static Console console = System.console();
    private String personalId;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;
    private String email;
    public Contact() {
        setPersonalId();
        setFirstName();
        setLastName();
        setphoneNum();
        this.address = "No address set";
        this.email = "No e-mail address set";
    }
    public String getPersonalId() {
            return this.personalId;
    }
    public void setPersonalId() {
        System.out.print("Set personal ID: ");
        String id = console.readLine();
        if (!(Validate.personalId(id))) {
            System.out.println("ID is not valid.");
            setPersonalId();
        } else {
            this.personalId = id;
        }
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName() {
        System.out.print("Set first name: ");
        String tempFirstName = console.readLine();
        if (!(Validate.name(tempFirstName))) {
            System.out.println("Name is not valid.");
            setFirstName();
        } else {
            this.firstName = tempFirstName;
        }
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName() {
        System.out.print("Set last name: ");
        String tempLastName = console.readLine();
        if (!(Validate.name(tempLastName))) {
            System.out.println("Name is not valid.");
            setLastName();
        } else {
            this.lastName = tempLastName;
        }
    }
    public String getPhoneNum() {
        return this.phoneNum;
    }
    public void setphoneNum() {
        System.out.print("Set phone number: ");
        String tempPhoneNum = console.readLine();
        if (!(Validate.phoneNum(tempPhoneNum))) {
            System.out.println("Phone number is not valid.");
            setphoneNum();
        } else {
            this.phoneNum = tempPhoneNum;
        }
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress() {
        System.out.print("Set address: ");
        String tempAddress = console.readLine();
        if (!(Validate.address(tempAddress))) {
            System.out.println("Address is not valid.");
            setAddress();
        } else {
            this.address = tempAddress;
        }
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail() {
        System.out.print("Set e-mail address: ");
        String tempEmail = console.readLine();
        if (!(Validate.email(tempEmail))) {
            System.out.println("E-mail address is not valid.");
            setEmail();
        } else {
            this.email = tempEmail;
        }
    }
    public String info() {
        String info = getPersonalId()
                    + getFirstName()
                    + getLastName()
                    + getPhoneNum()
                    + getAddress()
                    + getEmail();
        return info;
    }
}