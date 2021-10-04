package main;

import com.homeworkhopper.Tuple;

public class Main {
    public static void main(final String[] args) {

        // Create a Tuple containing three items
        Tuple.OfThree<Integer, Double, String> twoNumbers = Tuple.of(1, 2.0, "3");
        System.out.println(twoNumbers);

        // Use the var keyword to reduce long type declarations
        var twoNumbersAsVar = Tuple.of(1, 2.0, "3");
        System.out.println(twoNumbersAsVar);

        // Tuples can be stored as a non-generic Tuple object,
        // however items can no longer be directly accessed
        Tuple someTuple = Tuple.of(1, 2.0, "3");
        someTuple.asThree(Integer.class, Double.class, String.class).ifPresent(System.out::println);

        // If it is known that a given Tuple object contains items of
        // all the same type, a more concise operation can be preformed
        Tuple someTupleAllIntegers = Tuple.of(1, 2, 3);
        someTuple.asThree(Integer.class).ifPresent(System.out::println);

        // Tuples can be properly iterated over like so...
        Tuple sevenIntegers = Tuple.of(1, 2, 3, 4, 5, 6, 7);
        for (Tuple.TupleValue integer : sevenIntegers) {
            System.out.println(integer.value());
        }
    }
}