package au.com.blogspot.ojitha.trainings;

import org.jetbrains.annotations.NotNull;

public class GenericEx6 {

}

class Fruit implements Comparable<Fruit>{
    Fruit(String name) {this.name =name;}
    String name;
    @Override
    public int compareTo(@NotNull Fruit that) {
        return this.name.length() <that.name.length() ?-1 :
                this.name.length() == that.name.length() ? 0 : 1;
    }
}

class Apple extends Fruit{
    Apple(String name){ super(name); }
}
class Orange extends Fruit{
    Orange(String name) {super(name);}
}