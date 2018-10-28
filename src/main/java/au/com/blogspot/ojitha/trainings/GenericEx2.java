package au.com.blogspot.ojitha.trainings;

import java.util.ArrayList;
import java.util.List;

public class GenericEx2 {

    public static void main(String[] args) {
        List<X> xes = new ArrayList<X>(){
            {add(new X()); add(new X());}
        };

        List<Y> yes = new ArrayList<Y>(){
            {add(new Y()); add(new Y());}
        };

        min(xes); // this is success because X implements Comparable
        // min(yes); // not valid because not compatible with Comparable

    }

    public static <T extends Comparable> T min(List<T> list){
        if (list == null && list.size() == 0) return null;
        T small = list.get(0);
        for (T item: list) {
            if (small.compareTo(item) >0) small = item;
        }
        return small;
    }


}

class X implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Y {}