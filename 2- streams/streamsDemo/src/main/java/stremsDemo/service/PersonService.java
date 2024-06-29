package stremsDemo.service;

import stremsDemo.models.Item;
import stremsDemo.models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {
    public List<Person> getPersons(){
        return new ArrayList<>(List.of(
                new Person("Alan", "Screw", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        ));
    }

    public void maxPersonAge(){
        List<Person> persons = getPersons();
        persons.stream()
                .max((person1, person2) -> person1.getAge() - person2.getAge())
                .ifPresent(person -> System.out.println("the person with max age is : " + person));
    }

    public List<Person> getPersons2(){
        return new ArrayList<>(List.of(
                new Person("Bob", "Screw", 31),
                new Person("Paul", "Peters", 32),
                new Person("John", "Castle", 33)
        ));
    }

    public double streamPersons2(){
        List<Person> persons = getPersons2();
        return persons.stream()
                .filter(person -> person.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
//                .getAsDouble()
                .orElse(0.0)
                ;
    }
}
