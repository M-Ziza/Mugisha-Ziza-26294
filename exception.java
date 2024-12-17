

// Import necessary classes
import java.io.*;
import java.sql.*;

public class exception {

    // 1. IOException Example
    public static void triggerIOException() {
        try {
            // Trying to read a file that doesn't exist
            FileReader reader = new FileReader("example.txt");
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            System.out.println("IOException: Cannot open file. The file may not exist.");
        }
    }

    // 2. FileNotFoundException Example
    public static void triggerFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missing.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: File missing.txt is not found.");
        }
    }

    // 3. EOFException Example
    public static void triggerEOFException() {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
            DataInputStream data = new DataInputStream(stream);
            data.readUTF(); // Reading beyond input
        } catch (EOFException e) {
            System.out.println("EOFException: Reached end of file unexpectedly.");
        } catch (IOException e) {
            System.out.println("IOException: An I/O issue occurred.");
        }
    }

    // 4. SQLException Example
    public static void triggerSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:invalid:url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException: Cannot connect to database.");
        }
    }

    // 5. ClassNotFoundException Example
    public static void triggerClassNotFoundException() {
        try {
            Class.forName("some.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: Class not found at runtime.");
        }
    }

    // 6. ArithmeticException Example
    public static void triggerArithmeticException() {
        try {
            int result = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero is not allowed.");
        }
    }

    // 7. NullPointerException Example
    public static void triggerNullPointerException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Cannot perform operation on a null object.");
        }
    }

    // 8. ArrayIndexOutOfBoundsException Example
    public static void triggerArrayIndexOutOfBoundsException() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Index is out of range.");
        }
    }

    // 9. ClassCastException Example
    public static void triggerClassCastException() {
        try {
            Object obj = new String("Hello");
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: Cannot cast String to Integer.");
        }
    }

    // 10. IllegalArgumentException Example
    public static void triggerIllegalArgumentException() {
        try {
            setPositiveNumber(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: Negative value is not allowed.");
        }
    }

    public static void setPositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        System.out.println("Value set to: " + value);
    }

    // 11. NumberFormatException Example
    public static void triggerNumberFormatException() {
        try {
            String invalidNumber = "abc123";
            int num = Integer.parseInt(invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Invalid format for number conversion.");
        }
    }

    public static void main(String[] args) {
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
