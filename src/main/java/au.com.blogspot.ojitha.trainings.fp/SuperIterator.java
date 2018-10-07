package au.com.blogspot.ojitha.trainings.fp;


import java.util.Arrays;
import java.util.Iterator;

public class SuperIterator<E> implements Iterable<E> {
    private Iterable self;

    public SuperIterator (Iterable s){
        self =s;
    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }

    public static void main(String[] args) {
        SuperIterator<String> strings = new SuperIterator(
                Arrays.asList("z", "y", "l", "a", "b")
        );
    }
}
