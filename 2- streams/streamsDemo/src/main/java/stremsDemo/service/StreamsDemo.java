package stremsDemo.service;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public void FlatMapDemo(){
        Stream<List<String>> listStream =  Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        listStream
//                .peek(System.out::println)
                .filter(lst -> lst.contains("c"))
//                .peek(System.out::println)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    public void intStreamDemo(){
        IntStream intStream = IntStream.of(1, 2, 3);
        int sum = intStream.sum();
        System.out.println("sum is : " + sum);

        IntStream intStream2 = IntStream.of(1, 2, 3);
        OptionalInt max = intStream2.max();
        System.out.println("max is : " + max.getAsInt());
    }
    public void listIntegers(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 47, 33, 23));
        numbers.stream()
                .reduce((acc, current) -> acc > current ? acc : current)
                .ifPresent(max-> System.out.println("max is : " + max));

        System.out.println("max is : " + numbers.stream()
                .reduce(0, (acc, current) -> acc > current ? acc : current));
    }
}
