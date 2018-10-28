package au.com.blogspot.ojitha.trainings.fp;

import java.util.OptionalInt;

import static java.util.stream.IntStream.*;

public class StreamExample {
    public static void main(String[] args) {
        OptionalInt result = iterate(0, i -> i +1)
                .limit(100)
                .reduce((a,b)->a+b);

        result.ifPresent(System.out::println);
    }
}
