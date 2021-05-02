package com.example.java8pjt;

import java.util.function.*;

public class Foo1 {

    public static void main(String[] args) {
//        Plus10 plus10 = new Plus10();
//        System.out.println("plus10 = " + plus10.apply(1));

        /**
         * Function 함수
         * T -> R
         * apply 활용
         */

        // 클래스를 구현하는 것이 아닌 람다식으로 변경해보자
//        Function<Integer,Integer> plus10 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer+10;
//            }
//        };

        Function<Integer,Integer> plus10 = integer -> integer+10;
        System.out.println("plus10.apply(1) = " + plus10.apply(1));

        Function<Integer, Integer> mutiply2 = (i) -> i * 2;
        System.out.println("mutiply2.apply(1) = " + mutiply2.apply(1));
        
        // A.compose(B)
        // B -> A 순으로 동작
        // mutiply2 동작을 선행하고 이후 plue10 이 동작한다.
        Function<Integer, Integer> mutiply2AndPlus10 = plus10.compose(mutiply2);
        System.out.println("mutiply2AndPlus10.apply(2) = " + mutiply2AndPlus10.apply(2));
        // 2 * 2 + 10 = 14
        
        // A.andThen(B)
        // A -> B 순으로 동작
        Function<Integer, Integer> plus10AndMutiply2 = plus10.andThen(mutiply2);
        System.out.println("plus10AndMutiply2.apply(2) = " + plus10AndMutiply2.apply(2));
        // (2+10) * 2 = 24

        /**
         * UnaryOperator(T)
         * 설명 : 입력하는 값과 출력하는 형태가 같을 경우 사용
         * 입력 : T
         * 출력 : T
         */
        UnaryOperator<Integer> unaryPlus10 = (i) -> i+10;
        System.out.println("unaryPlus10.apply(2) = " + unaryPlus10.apply(2));


        /**
         *  BiFuntion(T,U,R)
         *  입력값 : T,U
         *  결과값 : R
         */
        BiFunction<Integer, Integer, Integer> AplusB = (a, b) -> a+b;
        System.out.println("AplusB.apply(1,2) = " + AplusB.apply(1,2));

        /**
         * BinaryOperator(T)
         * 설명 : 3개의 변수값이 모두 같은 경우 사용
         * 입력 : (T, T)
         * 출력 : T
         */
        BinaryOperator<Integer> binaryOperator = (a,b) -> a+b;
        System.out.println("binaryOperator.apply(1,2) = " + binaryOperator.apply(1,2));

        /**
         * Consumer(T)
         * 입력값 : T
         * 결과값 : void
         */
        Consumer<Integer> printT = (i) -> System.out.println("Consumer print value = "+i);
        printT.accept(1);

        /**
         * BiConsumer(T, U)
         * 입력값 : T, U
         * 결과값 : void
         */
        BiConsumer<Integer, Integer> biConsumer = (a,b) -> System.out.println("biConsumer a+b = " + (a+b));
        biConsumer.accept(1,2);

        /**
         * Supplier(T)
         * 입력값 : 없음
         * 출력값 : T
         */
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10.get() = " + get10.get());


        /**
         * Predicate(T)
         * 입력값 : T
         * 출력값 : boolean
         *
         * boolean test(T) 함수로 return
         * 함수 조합용 메소드
         *  -- and, or, Negate 활용 가능
         */
        Predicate<String> startWithBang = (s) -> s.startsWith("bang");
        System.out.println("startWithBang.test(\"bangJeongHwan\") = " + startWithBang.test("bangJeongHwan"));

        Predicate<Integer> isEven = (i) -> i%2==0;
        System.out.println("isEven.test(2) = " + isEven.test(2));

        // 2의 배수 체크
        Predicate<Integer> isMultple2 = (i) -> i%2==0;

        // 3의 배수 체크
        Predicate<Integer> isMultple3 = (i) -> i%3==0;

        // and
        // 2의 배수이면서 3의 배수인가?
        Predicate<Integer> isMultple2AndMultple3 = isMultple2.and(isMultple3);
        System.out.println("isMultple2AndMultple3.test(3) = " + isMultple2AndMultple3.test(6));

        // or
        // 2의 배수 또는 3의 배수인가?
        Predicate<Integer> isMultple2OrMultple3 = isMultple2.or(isMultple3);
        System.out.println("isMultple2OrMultple3.test(3) = " + isMultple2OrMultple3.test(3));

        // negate
        // 2의 배수가 아닌가?
        Predicate<Integer> negateMultple2 = isMultple2.negate();
        System.out.println("negateMultple2.test(2) = " + negateMultple2.test(2));

        /**
         * BiPredicate(T, U)
         * 입력값 : T, U
         * 출력값 : boolean
         */
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a-b>0;
        System.out.println("biPredicate.test(2,1) = " + biPredicate.test(2,1));
    }

}
