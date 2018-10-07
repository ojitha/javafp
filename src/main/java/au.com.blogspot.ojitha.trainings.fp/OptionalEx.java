package au.com.blogspot.ojitha.trainings.fp;

import au.com.blogspot.ojitha.trainings.fp.domain.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {

        Map<String, Person> people = new HashMap<>();

        people.put("A", Person.getPersonFA("FA", "LA"));
        people.put("B", Person.getPersonFA("FB", "LB"));
        people.put("C", Person.getPersonFA("FC", "LC"));
        people.put("D", Person.getPersonFA("FD", "LD"));
        people.put("E", Person.getPersonA("AE", 23));

        Optional<Map<String, Person>> peopleOpt = Optional.of(people);
        peopleOpt.map(p -> p.get("E"))
        .map(person -> person.getAge())
        .ifPresent(e -> System.out.println(e));
    }
}

