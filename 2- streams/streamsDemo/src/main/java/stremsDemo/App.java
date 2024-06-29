package stremsDemo;

import stremsDemo.service.BookService;
import stremsDemo.service.ItemService;
import stremsDemo.service.PersonService;
import stremsDemo.service.StreamsDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(intStreamDemo());
        ItemService itemService = new ItemService();
        itemService.streamItems();


        StreamsDemo streamsDemo = new StreamsDemo();
        streamsDemo.FlatMapDemo();
        streamsDemo.intStreamDemo();
        streamsDemo.listIntegers();


        PersonService personService = new PersonService();
        personService.maxPersonAge();
        System.out.println(personService.streamPersons2());


        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN"));
        if(grade2.isPresent()){
            grade2.ifPresent(System.out::println);
        }else {
            System.out.println(grade2.orElse("Empty"));
        }


        BookService bookService = new BookService();
        OptionalDouble optionalDouble1 = bookService.streamBooks(10);
        optionalDouble1.ifPresent(System.out::println);
        OptionalDouble optionalDouble2 = bookService.streamBooks(90);
        optionalDouble2.ifPresent(System.out::println);
        bookService.streamBooks2();
        bookService.streamBooks3();
        bookService.streamBooks4();

        doubleStreamDemo();


        lazyEvaluationDemo();


        optionalDouble();

        fixMethod();
    }
    public static double intStreamDemo(){
        return IntStream.range(0, 5)
                .average().getAsDouble();
    }
    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        }
        else {
            grade = Optional.of("FAIL");
        }
        return grade;
    }

    private static void optionalDouble(){
        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));


        Optional<Double> price2 = getPrice2();
        System.out.println(price2.orElse(0.0));
        if (price2.isEmpty()){
            System.out.println("empty");
        }
        price2.ifPresent(amount -> System.out.println(amount));

        Double x = price2.orElse(44.0);
        System.out.println(x);

//        Optional<Double> price3 = getPrice2();
//        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
//        System.out.println(z);

    }

    private static Optional<Double> getPrice2() {
        return Optional.ofNullable(null);
    }

    private static void doubleStreamDemo(){
        DoubleStream ds = DoubleStream.of( 0, 2, 4);
        double sum = ds.filter(num -> num % 2 != 0)
                .sum();
        System.out.println(sum);

        Stream<Double> stream = Stream.of(1.0, 3.0);
        OptionalDouble average = stream.mapToDouble(x -> x)
                .filter(x -> x % 2 == 0)
                .average();
        average.ifPresent(System.out::println);

    }

    public static void lazyEvaluationDemo(){
        List<Integer> ls =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        System.out.println(ls.stream()
                .distinct()
                .anyMatch(x -> x == 11));

        System.out.println(ls.stream()
                .noneMatch(x -> x%11>0));
    }
    public static void fixMethod(){
        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e % 2 == 0;
        }).forEach(System.out::println);
        System.out.println(ai);
    }
}
