// Import necessary classes
import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    // 1. IOException Example
    public static void triggerIOException() {
        try {
            // Trying to open a file that does not exist will trigger an IOException
            FileReader reader = new FileReader("example.txt");
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            // Catching the IOException and printing an error message
            System.out.println("IOException: Cannot open file. The file may not exist.");
        }
    }

    // 2. FileNotFoundException Example
    public static void triggerFileNotFoundException() {
        try {
            // Trying to read from a file that does not exist
            FileInputStream file = new FileInputStream("missing.txt");
        } catch (FileNotFoundException e) {
            // Catching the FileNotFoundException and printing an error message
            System.out.println("FileNotFoundException: File missing.txt is not found.");
        }
    }

    // 3. EOFException Example
    public static void triggerEOFException() {
        try {
            // Simulating reading past the end of a file (EOFException)
            ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
            DataInputStream data = new DataInputStream(stream);
            data.readUTF(); // This will throw EOFException as there is no data
        } catch (EOFException e) {
            // Catching EOFException and printing an error message
            System.out.println("EOFException: Reached end of file unexpectedly.");
        } catch (IOException e) {
            // Catching any other I/O exception
            System.out.println("IOException: An I/O issue occurred.");
        }
    }

    // 4. SQLException Example
    public static void triggerSQLException() {
        try {
            // Trying to connect to an invalid database URL (this will cause SQLException)
            Connection conn = DriverManager.getConnection("jdbc:invalid:url", "user", "password");
        } catch (SQLException e) {
            // Catching SQLException and printing an error message
            System.out.println("SQLException: Cannot connect to database.");
        }
    }

    // 5. ClassNotFoundException Example
    public static void triggerClassNotFoundException() {
        try {
            // Trying to load a class that does not exist, which will trigger ClassNotFoundException
            Class.forName("some.NonExistentClass");
        } catch (ClassNotFoundException e) {
            // Catching ClassNotFoundException and printing an error message
            System.out.println("ClassNotFoundException: Class not found at runtime.");
        }
    }

    // 6. ArithmeticException Example
    public static void triggerArithmeticException() {
        try {
            // Performing division by zero, which will trigger an ArithmeticException
            int result = 5 / 0;
        } catch (ArithmeticException e) {
            // Catching ArithmeticException and printing an error message
            System.out.println("ArithmeticException: Division by zero is not allowed.");
        }
    }

    // 7. NullPointerException Example
    public static void triggerNullPointerException() {
        try {
            // Trying to access a method on a null object, which will cause a NullPointerException
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            // Catching NullPointerException and printing an error message
            System.out.println("NullPointerException: Cannot perform operation on a null object.");
        }
    }

    // 8. ArrayIndexOutOfBoundsException Example
    public static void triggerArrayIndexOutOfBoundsException() {
        try {
            // Trying to access an invalid index in an array
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catching ArrayIndexOutOfBoundsException and printing an error message
            System.out.println("ArrayIndexOutOfBoundsException: Index is out of range.");
        }
    }

    // 9. ClassCastException Example
    public static void triggerClassCastException() {
        try {
            // Trying to cast a String object to Integer, which will cause a ClassCastException
            Object obj = new String("Hello");
            Integer num = (Integer) obj; // This will throw ClassCastException
        } catch (ClassCastException e) {
            // Catching ClassCastException and printing an error message
            System.out.println("ClassCastException: Cannot cast String to Integer.");
        }
    }

    // 10. IllegalArgumentException Example
    public static void triggerIllegalArgumentException() {
        try {
            // Passing a negative value to a function that expects a positive value
            setPositiveNumber(-10); // This will throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            // Catching IllegalArgumentException and printing an error message
            System.out.println("IllegalArgumentException: Negative value is not allowed.");
        }
    }

    // Helper method for IllegalArgumentException example
    public static void setPositiveNumber(int value) {
        // Throwing an exception if the value is negative
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        System.out.println("Value set to: " + value);
    }

    // 11. NumberFormatException Example
    public static void triggerNumberFormatException() {
        try {
            // Trying to parse an invalid string as an integer
            String invalidNumber = "abc123";
            int num = Integer.parseInt(invalidNumber); // This will throw NumberFormatException
        } catch (NumberFormatException e) {
            // Catching NumberFormatException and printing an error message
            System.out.println("NumberFormatException: Invalid format for number conversion.");
        }
    }

    public static void main(String[] args) {
        // Calling each example method
        System.out.println("--- Checked Exceptions ---");
        triggerIOException();
        triggerFileNotFoundException();
        triggerEOFException();
        triggerSQLException();
        triggerClassNotFoundException();

        System.out.println("\n--- Unchecked Exceptions ---");
        triggerArithmeticException();
        triggerNullPointerException();
        triggerArrayIndexOutOfBoundsException();
        triggerClassCastException();
        triggerIllegalArgumentException();
        triggerNumberFormatException();
    }
}
