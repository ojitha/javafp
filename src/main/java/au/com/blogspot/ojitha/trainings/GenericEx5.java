package au.com.blogspot.ojitha.trainings;

import java.util.ArrayList;
import java.util.List;

public class GenericEx5 {

    @SafeVarargs
    public static <T>  void addMore(List<T> list, T... t){
        for (T elem: t) {
            list.add(elem);
        }
    }
    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>(){{add("a");add("b");}};
        addMore(sList, "C", "D");
        sList.stream().forEach(System.out::println);

    }
}
