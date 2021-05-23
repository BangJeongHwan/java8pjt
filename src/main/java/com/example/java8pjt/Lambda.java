package com.example.java8pjt;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {

        Supplier<Integer> get10 = () -> 10;
        // 타입을 정할 수도 있고,
        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a+b;
        // 정하지 않아도 함수로써 확인이 가능하다.
        BinaryOperator<Integer> sum1 = (a, b) -> a+b;

        Lambda lambda = new Lambda();
        lambda.run();

    }
    private void run(){
        // final를 붙이지 않아도 사실상 내부에서 변하지 않으면 자동으로 final 처리가 된다.
        int baseNumber = 10;

        // 로컬클래스, 익명클래스, 람다
        // 공통점 : baseNumber를 활용할 수 있다.
        // 람다의 차이점 : 쉐도윙이 안된다.

        // 로컬 클래스
        class localClass {
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber);  // 결과 : 11
            }
        }

        // 익명 클래스
        Consumer<Integer> IntgerConsumber = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);  // 결과 : 11
            }
        };

        // 람다
        // 위의 run과 같은 스코프에 해당되서 i 를 baseNumber로 대체할 수 없다.
//        IntConsumer printInt = (baseNumber) -> {
//            System.out.println(baseNumber);
        IntConsumer printInt = (i) -> {
            System.out.println(i+baseNumber);
        };
        printInt.accept(10);
        // 또한 람다는 아래와 같이 변수가 이팩티브 final 이 아니면 참조할 수 없다.
//        baseNumber++;

    }
}
