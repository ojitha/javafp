package au.com.blogspot.ojitha.trainings.fp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class  Person {

    private String fName;
    private String lName;
    private Integer age;


    public static Person getPersonFA(String fName, String lName){
        Person p = new Person();
        p.fName = fName;
        p.lName = lName;
        p.age = null;

        return p;
    }

    public static Person getPeronF(String fName){
        Person p = new Person();
        p.fName = fName;
        p.lName = null;
        p.age = null;
        return p;
    }

    public static Person getPersonA(String fName,int age){
        Person p = new Person();
        p.fName = fName;
        p.age = age;
        return p;
    }
}
