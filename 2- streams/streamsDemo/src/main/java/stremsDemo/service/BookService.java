package stremsDemo.service;


import stremsDemo.models.AnotherBook;
import stremsDemo.models.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    public List<Book> getBooks(){
        return new ArrayList<>(List.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        ));
    }

    public List<Book> getBooks2(){
        return new ArrayList<>(List.of(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        ));
    }
    public List<Book> getBooks3(){
        return new ArrayList<>(List.of(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        ));
    }

    public OptionalDouble streamBooks(double filterAmount){
        List<Book> books = getBooks();
        return books.stream()
                .filter(book -> book.getPrice() > filterAmount)
                .mapToDouble(Book::getPrice)
                .average();
    }

    public void streamBooks2(){
        List<Book> books = getBooks2();
        Map<String, Double> bookMap = books.stream()
                .collect(
                        Collectors.toMap(
                                book -> book.getTitle(),
                                book -> book.getPrice()
                                )
                );
        bookMap.forEach((key, val) -> {
            if (key.startsWith("A")){
                System.out.println(val);
            }
        });

    }

    public void streamBooks3(){
        List<Book> books = getBooks3();
        books.stream()
                .collect(
                        Collectors.toMap(
                                book -> book.getTitle(),
                                book -> book.getPrice(),
                                (bookPrice1, bookPrice2) -> bookPrice2
                        )
                )
                .forEach((key, val) -> System.out.println(key + " " + val));
    }

    public List<AnotherBook> getBooks4(){
        return new ArrayList<>(List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        ));
    }

    public void streamBooks4(){
        List<AnotherBook> books = getBooks4();
        List<String> genreList = new ArrayList<>();
        genreList = books.stream()
                .map(AnotherBook::getGenre)
                .collect(Collectors.toList());
        System.out.println(genreList);
    }
}
