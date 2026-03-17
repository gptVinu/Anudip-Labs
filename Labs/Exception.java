public class ArrayExceptionDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("Accessing array elements:");
            // The loop runs from 0 to 5. 
            // Since the last index is 4, it will crash when i = 5.
            for (int i = 0; i <= numbers.length; i++) {
                System.out.println("Index " + i + ": " + numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: You tried to access an index that doesn't exist!");
            System.out.println("Exception message: " + e);
        }
    }
}
/*
Output :

Accessing array elements:
Index 0: 10
ERROR!
Index 1: 20
Index 2: 30
Index 3: 40
Index 4: 50

Error: You tried to access an index that doesn't exist!
Exception message: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
*/
