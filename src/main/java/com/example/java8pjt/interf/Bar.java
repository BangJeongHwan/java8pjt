package com.example.java8pjt.interf;

public interface Bar {

    // FooInterface 제공하는 default 매소드를 제공하지 않기 위해서는 아래와 같이 추상매소드로 선언 한다.
//    void printNameUpperCase();


    // 다이아몬드 프라브럼
    default void printNameUpperCase(){
        System.out.println("BAR");
    }
}
