package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {

    public static void main(String[] args) {
        // A list of fruits to work with
        List<String> fruits = List.of("apple", "banana", "mango");

        // Predicate to check if the fruit starts with the letter "c"
        Predicate<? super String> predicate = fruit -> fruit.startsWith("c");

        // Use stream to filter fruits that match the predicate and get the first one
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();

        // Output the Optional object (could be empty if no match is found)
        System.out.println(optional);

        // Check if the optional is empty (i.e., no value present)
        System.out.println("Is Optional empty? " + optional.isEmpty());

        // Check if a value is present in the optional
        System.out.println("Is value present? " + optional.isPresent());

        // Trying to access the value inside the Optional
        // This will throw a java.util.NoSuchElementException if no value is found
        // Optional.get() should be used carefully; better to use safe alternatives like orElse
        if (optional.isPresent()) {
            System.out.println("Found value: " + optional.get());
        } else {
            System.out.println("No value found that starts with 'c'");
        }

        // Creating an Optional with a non-null value
        Optional<String> fruit = Optional.of("Banana");

        // Creating an Optional with an empty string value (but not null)
        Optional<String> empty = Optional.of("");
        
        // Safer way to handle optionals
        System.out.println("Safe handling of Optional value: " + optional.orElse("Default value"));
    }
}
