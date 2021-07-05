package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces a result
        int increment = increment(1);
        System.out.println(increment);

        int increment2 =  incrementByOne.apply(1);
        System.out.println(increment2);

        int product = multiplyByTen.apply(increment2);
        System.out.println(product);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOne.andThen(multiplyByTen);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        // BiFunction takes 2 arguments and produces a result
        System.out.println(incrementByOneAndMultiply(4,100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
        (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiply) {
        return (number + 1) * numToMultiply;
    }
}
