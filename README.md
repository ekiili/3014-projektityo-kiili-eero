# Contacts App
This is a Contacts application made using Java 17. It uses a **command line interface (CLI)** to let users create, read, update, and delete contact information.

## Instructions
To run the program: 
- Clone/download this repository
- Navigate to the root directory in a terminal
- Execute the command:

```cd src/ && javac *.java && java ContactsApp```

## Structure

- **ContactsApp.java:** Contains the main application logic and user interface.
- **Contact.java:** Manages contact information and file I/O.
- **Validate.java:** Validates user input.
- All information is stored in two text files:
  
    - **contacts.txt:** Contacts stored in a "box format".
        This file is displayed to the user.

    - **contactData.txt:** Contact information stored one after the other separated by a comma.
      
        This file is used for creating an ArrayList every time the program starts

## Other

### Link to screencast
https://www.youtube.com/watch?v=lr4MCNzOUnM

### Classes imported
- [Console](https://docs.oracle.com/javase/8/docs/api/java/io/Console.html)
- [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)
- [BufferedWriter](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)
- [FileWriter](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html)
- [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
- [FileReader](https://docs.oracle.com/javase/8/docs/api/?java/io/FileReader.html)
