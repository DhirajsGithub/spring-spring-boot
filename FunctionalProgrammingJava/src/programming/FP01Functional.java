package programming;

import java.util.List;

/*
 * In functional programming, we focus on *what* to do rather than *how* to do it.
 * Java Streams provide a functional way to process sequences of elements (like a List) 
 * with operations such as filtering, mapping, and reducing. These operations use
 * lambda functions to define the desired behavior in a concise and readable way.
 */
public class FP01Functional {
    public static void main(String[] args) {
        // Initializing a list of numbers
        List<Integer> numbers = List.of(2, 3, 9, 7, 79, 98932, 8, 6, 9, 2, 44, 89);

        // Uncomment each method call to test different functionality:
        // printAllNumberInListFunctional(numbers);   // Prints all numbers in the list
        // printEvenNumberInListFunctional(numbers);  // Prints only even numbers in the list
        printEventNumberSquareInListFunctional(numbers); // Prints squares of even numbers
    }

    // Method to print a number (used for method references)
    private static void print(int num){
        System.out.println(num);
    }

    // Prints all numbers in the list using streams and method reference
    private static void printAllNumberInListFunctional(List<Integer> numbers){
        /*
         * Streams: 
         * A sequence of elements (in this case, numbers) that can be processed
         * with functional operations like `forEach`, `filter`, and `map`.
         *
         * Method Reference (`System.out::println`):
         * Instead of writing a lambda, we can directly reference an existing method
         * to execute for each element. In this case, we are referencing `println` to
         * print each number.
         */
        // numbers.stream().forEach(FP01Functional::print)
        numbers.stream().forEach(System.out::println); 
    }

    // Predicate to check if a number is even
    private static boolean isEven(int num){
        return num % 2 == 0;
    }

    // Prints only even numbers from the list using streams and filtering with a lambda
    private static void printEvenNumberInListFunctional(List<Integer> numbers){
        /*
         * filter():
         * The filter method takes a **predicate** (a function that returns a boolean) 
         * and returns a stream containing only elements that match the predicate (i.e., 
         * for which the predicate returns true). In this case, we are filtering to get 
         * only even numbers.
         *
         * Lambda Expression (`number -> number % 2 == 0`):
         * A lambda is an anonymous function. Here, it's a short function that takes 
         * a number and returns whether it's even. The lambda replaces the need for
         * writing a separate `isEven()` method.
         */
        numbers.stream()
               .filter(number -> number % 2 == 0)  // Filters even numbers
               .forEach(System.out::println);      // Prints each even number
    }

    // Prints the square of each even number in the list
    private static void printEventNumberSquareInListFunctional(List<Integer> numbers){
        /*
         * map():
         * The map method is used to transform each element in the stream. It takes a 
         * function as an argument and applies that function to each element, returning
         * a stream of the results. In this case, we're transforming (mapping) each even
         * number to its square.
         *
         * Lambda Expression (`number -> number * number`):
         * This lambda function takes a number and returns its square.
         */
        numbers.stream()
               .filter(number -> number % 2 == 0)  // Filters even numbers
               .map(number -> number * number)     // Maps each even number to its square
               .forEach(System.out::println);      // Prints each squared even number
    }
}
