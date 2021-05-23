package com.example.java8pjt.interf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App1 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("jeong");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

//        name.forEach(s -> {
//            System.out.println(s);
//        });
        // 위와 같은 방식
//        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        // 반으로 조개는 일을 한다. (spliterator.trySplit())
        // 순서에 상관없이 균등하게 나누는 작업을 한다.
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=========================");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("\n************** stream *****************");
        // stream
        // stream에 기반에는 spliterator 가 존재한다.
        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("F"))
                .count();
        System.out.println(k);

        Object k1 = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("F"))
                .collect(Collectors.toSet());
        System.out.println(k1.toString());

        System.out.println("\n************** removeIf(삭제) *****************");
        name.removeIf(s->s.startsWith("f"));
        name.forEach(System.out::println);

        System.out.println("\n************** Comparator(정렬) *****************");
        name.sort(String::compareToIgnoreCase);
//        name.forEach(System.out::println);


        // 역순으로 정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        // 추가적인 정렬이 필요할 경우 추가적으로 .thenComparing()를 붙인다.


    }
}
