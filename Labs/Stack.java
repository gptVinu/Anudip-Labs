package Java_Programmings;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // stack creation of countries
        Stack<String> countries = new Stack<>();

        // adding elements
        countries.push("Sydney");
        countries.push("Mexico");
        countries.push("Brazil");
        countries.push("Germany");

        System.out.println("Current Stack: " + countries);

        // top element
        System.out.println("Top Element: " + countries.peek());

        // removing the element
        String removed = countries.pop();
        System.out.println("Removed Element: " + removed);

        // checking it is empty or not
        System.out.println("Is Stack empty? " + countries.empty());

        // final stakc
        System.out.println("Stack after pop: " + countries);
    }
}

/*
Output : 

Current Stack: [Sydney, Mexico, Brazil, Germany]
Top Element: Germany
Removed Element: Germany
Is Stack empty? false
Stack after pop: [Sydney, Mexico, Brazil]
*/
