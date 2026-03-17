import java.util.ArrayList;
import java.util.List;

public class EvenSumCalculator {
    public static void main(String[] args) {
        //Creating and adding the elements to the ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        int sum = 0;
        //using loop
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        
        System.out.println("Sum of even numbers: " + sum);
    }
}
/*
Output : 

Sum of even numbers: 60
*/
