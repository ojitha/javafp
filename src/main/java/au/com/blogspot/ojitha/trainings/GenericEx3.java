package au.com.blogspot.ojitha.trainings;

import java.lang.reflect.Array;
import java.util.function.Supplier;

public class GenericEx3 {
    public static void main(String[] args) {

        A<Number>[] an = new A[10];
        an[0] = new A();
        // an[1] = new AS(); //not possible to compile.
        // an[2] = new AI(); //not possible to compile.
        an[3] = new AN();

        A<String>[] as = new A[10];
        as[0] = new A();
        as[1] = new AS();
        // as[2] = new AI(); //not possible to compile.
        // as[3] = new AN(); //not possible to compile.

        A<Integer>[] ais = new A[10];
        ais[0] = new A();
        // ais[1] = new AS(); //not possible to compile.
        ais[2] = new AI();
        // ais[3] = new AN(); //not possible to compile.

        //----------------------------

        B<Number>[] bn = new B[10];
        bn[0] = new B();
        // bn[2] = new BI(); //not possible to compile.
        bn[3] = new BN(); //not possible to compile.

        B<Integer>[] bis = new B[10];
        bis[0] = new B();
        bis[2] = new BI();
        // bis[3] = new BN(); //not possible to compile.
    }


}

class A<T> { }
class AN extends A<Number> {}
class AS extends A<String> {}
class AI extends A<Integer> {}

//------------------------------

class B<T extends Number> {}
class BN extends B<Number> {}
// class BS extends B<String> {}
class BI extends B<Integer> {}

