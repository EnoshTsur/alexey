package main;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {

        int res =  doWith(Main::isContainsA, "Ity")
                .andThen(r -> r + " hahaha!")
                .andThen(String::length)
                .apply(addHi, addBye);


        System.out.println(
            res
        );
    }

    public static Function<String, String> addHi = str -> str + " Hi!";
    public static Function<String, String> addBye = str -> str + " Bye";

    public static boolean isContainsA(String value) {
        return Optional.ofNullable(value)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(str -> str.contains("a"))
                .orElse(false);
    }

    public static BiFunction<
            Function<String, String>,
            Function<String, String>,
            String> doWith(Predicate<String> condition, String value) {
       return ( fn1, fn2) -> condition.test(value) ? fn1.apply(value) : fn2.apply(value);
    }

}

