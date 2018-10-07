package au.com.blogspot.ojitha.trainings.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ElementFinder<E> {
    public static void main(String[] args) {
        //for Integers
        List<Integer> ints = Arrays.asList(1,2,3,4);
        ElementFinder<Integer> integerHello = new ElementFinder<>();
        List<Integer> integerList = integerHello.find(ints.iterator(), c -> c >2);
        integerList.forEach(e -> System.out.println(e));

        //for Strings
        List<String> strings = Arrays.asList("H","E","L","L","O");
        ElementFinder<String> stringHello = new ElementFinder<>();
        List<String> stringList = stringHello.find(strings.iterator(), c -> c.equals("L"));
        stringList.forEach(e -> System.out.println(e));

    }

    @FunctionalInterface
    interface Criteria<E> {
        boolean is(E e);
    }

    public List<E> find(Iterator<E> iterator, Criteria<E> criteria){
      List<E> ret = new ArrayList<>();
      while(iterator.hasNext()){
          E e = iterator.next();
          if (criteria.is(e)){
              ret.add(e);
          }
      }
      return ret;
    }
}
