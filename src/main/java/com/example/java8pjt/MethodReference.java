package com.example.java8pjt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = (s) -> "hi" + s;
        // 위와 동일한 기능을 하는 매소드 레퍼런스
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi2.apply("정환"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("방"));

        // 문자열을 받지 않는 생성자를 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();  // get을 해야 객체를 생성함

        // 문자열을 받는 생성자를 참조
        Function<String, Greeting> jeongHwanGreeting = Greeting::new;
        Greeting jeongHwan = jeongHwanGreeting.apply("jeongHwan");
        System.out.println(jeongHwan.getName());


        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"jeong", "whiteship", "toby"};
        // Comparator
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return 0;
//            }
//        });
        // Comparator를 람다로 변경 가능
//        Arrays.sort(names, (s, t1) -> 0);

        // 매소드 레퍼런스 활용 가능
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
