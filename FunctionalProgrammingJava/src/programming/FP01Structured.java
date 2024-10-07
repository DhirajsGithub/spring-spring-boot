package programming;
import java.util.List;
public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 9, 7, 79, 98932, 69);

        // printAllNumberInListStructured(numbers);
        printEvenNumberInListFunctional(numbers);
    }
    private static void printAllNumberInListStructured(List<Integer> numbers){
        for(int n : numbers){
            System.out.println(n);
        }
    }
    private static void printEvenNumberInListFunctional(List<Integer> numbers){
        for(int n : numbers){
            if(n%2 == 0){
                System.out.println(n);
            }
        }
    }
}
