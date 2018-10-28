package au.com.blogspot.ojitha.trainings;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.IntFunction;

public class GenericEx4 {
    public static <T> T[] createNumberArray(T... t){
        T[] arrayT =  (T[])Array.newInstance(t.getClass().getComponentType(), t.length);
        //...
        return arrayT;
    }

    public static <T> T[] createArray(IntFunction<T[]> c, T... t){
        T[] arrayT = c.apply(t.length);
        // ...
        return arrayT;
    }

    public static <T extends Comparable<T>> T min(T[] t){
        return t[0];
    }

    public static void main(String[] args) {
        Integer[] ints1 = createNumberArray(1,2,3);

        Integer[] ints2 = createArray(Integer[]::new, 1,2,0,3);
        Arrays.stream(ints1).forEach(System.out::println);

        min(ints1);
        String[] strings = new String[10];
        min(strings);

        LocalDate[] localDates = new LocalDate[10];
        min(localDates);

    }
}

