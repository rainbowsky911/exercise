package com.example.demo.stream;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface MyInterface {
    int myInt(int x);

    String myString(String str);
}

public class StreamDemo {

    public static void main(String[] args) {

        Book book1 = new Book(11, "a", 33);
        Book book2 = new Book(12, "b", 100);
        Book book3 = new Book(16, "css", 11);
        Book book4 = new Book(8, "dsss", 33);
        Book book5 = new Book(25, "e", 27);
        Book book6 = new Book(4, "qwEr", 100);

        List<Book> list = Arrays.asList(book1, book2, book3, book4, book5, book6);
        System.out.println(list);

        //1
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("kobe"));

        //2
        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test("s"));

        //3
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("科比抢人头");

        //4
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };

        Supplier<String> stringSupplier = () -> {

            return "java";
        };
        System.out.println(stringSupplier.get());











       /* list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        list.add(book6);
*/
       /* Collections.sort(list);

        for (Book book:list
             ) {
            System.out.println(book);

        }*/


    }
}

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
class Book implements Comparable<Book> {

    private int id;
    private String name;
    private int age;


    @Override
    public int compareTo(Book book) {

        int tmp = this.getAge() - book.getAge();
        if (tmp == 0) {
            return this.getId() - book.getId();
        }
        return tmp;
    }
}