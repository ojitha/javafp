package au.com.blogspot.ojitha.trainings;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericEx1 {
    public static void main(String[] args) {

       List<String> stringList = Stream.of("a", "b")
                .collect(Collectors.toList());
       GenericEx1.<String>show(stringList);

    }

    public static  <T, R> void testFun(Function<? super T, ? extends R> lambda){

    }
    //Example of simplest use of the type variable
    public static <T> void show(List<T> list){
        list.stream().peek(System.out::print);
    }


}

