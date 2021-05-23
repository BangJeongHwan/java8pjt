package com.example.java8pjt.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("jeong");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        Stream<String> StringStream = names.stream().map(String::toUpperCase);

        // 위와 같이 처리가 되었어도 기존 names의 값은 변하지 않는다.
        names.forEach(System.out::println);
        StringStream.forEach(System.out::println);

        System.out.println("\n============================");
        // 중계형 오퍼레이터 (map) 동작하지 않는다.
        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("\n============================");
        // 종료형 오퍼레이터 동작한다.
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("\n============================");
        // stream은 병렬 처리가 가능하다.
//        List<String> collect1 = names.parallelStream().map(String::toUpperCase)
//                .collect(Collectors.toList());
//        collect1.forEach(System.out::println);

        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s+" "+Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }
}
