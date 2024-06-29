package demos.ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class BasicLambdas
{
    public static void main( String[] args )
    {
        BasicLambdas basicLambdas = new BasicLambdas();

        consumer();
        supplier();
        predicate();

        System.out.println(basicLambdas.check(4, x -> x % 2 == 0));
        System.out.println(basicLambdas.check(7, x -> x % 2 == 0));

        System.out.println(basicLambdas.check("Mr. Joe Bloggs", x -> x.startsWith("Mr.")));
        System.out.println(basicLambdas.check("Ms. Ann Bloggs", x -> x.startsWith("Mr.")));

        Person Mike = new Person("Mike", 33, 1.8);
        Person Ann = new Person("Ann", 13, 1.4);
        System.out.println(basicLambdas.check(Mike, x -> x.getAge() >= 18));
        System.out.println(basicLambdas.check(Ann, x -> x.getAge() >= 18));

        function();

        List<Person> listPeople = getPeople();
        listPeople.forEach(person -> System.out.println(person));

        sortAge(listPeople);
        listPeople.forEach(person -> System.out.println(person));
        sortName(listPeople);
        listPeople.forEach(person -> System.out.println(person));
        sortHeight(listPeople);
        listPeople.forEach(person -> System.out.println(person));

    }
    public static void consumer(){
        Printable<String> printableLambda = (s -> System.out.println(s));
        printableLambda.print("Printable lambda");
        Consumer<String> consumerLambda = (s -> System.out.println(s));
        Consumer<String> consumerMR = (System.out::println);
        consumerLambda.accept("Printable lambda");
        consumerMR.accept("Printable lambda");
    }
    public static void supplier(){
        Retrievable<Integer> retrievableLambda = () -> 77;
        System.out.println(retrievableLambda.retrieve());
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }
    public static void predicate(){
        Evaluate<Integer> evaluator = x -> x < 0;
        System.out.println(evaluator.isNegative(-1));
        System.out.println(evaluator.isNegative(1));
        Predicate<Integer> predicate = x -> x < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));
    }
    public <T> boolean check(T t, Predicate<T> predicate){
        return predicate.test(t);
    }
    public static void function(){
        Functionable<Integer, String> functionable = x -> String.format("Number is: %d", x);
        System.out.println(functionable.applyThis(25));
        Function<Integer, String> function = x -> String.format("Number is: %d", x);
        System.out.println(function.apply(25));
    }
    private static void sortAge(List<Person> persons){
        persons.sort(Comparator.comparing(
                Person::getAge
        ));
    }
    private static void sortName(List<Person> persons){
        persons.sort(Comparator.comparing(
                Person::getName
        ));
    }

    private static void sortHeight(List<Person> persons){
        persons.sort(Comparator.comparing(
                Person::getHeight
        ));
    }
    private static List<Person> getPeople() {

        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));

        result.add(new Person("Mary", 25, 1.4));

        result.add(new Person("Alan", 34, 1.7));

        result.add(new Person("Zoe", 30, 1.5));

        return result;

    }

}
