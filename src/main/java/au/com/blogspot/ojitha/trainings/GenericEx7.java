package au.com.blogspot.ojitha.trainings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericEx7 {
    public static void main(String[] args) {
        sum(Arrays.<Integer>asList(1,2,3));
        sum(Arrays.<Double>asList(1.2,3.4));
        sum(Arrays.<Number>asList(1,2,2.4));

        count(Arrays.<Integer>asList(1,2,3));
        //count(Arrays.<Double>asList(1.2,3.4));
        count(Arrays.<Number>asList(1,2,2.4));


    }

    public static double sum (Collection<? extends Number> numbers){
        double s = 0.0;
        for (Number number: numbers) { s += number.doubleValue(); }
        return s;
    }

    public static void count(Collection<? super Integer> ints){

    }


}
