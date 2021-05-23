package com.example.java8pjt.interf;

public interface FooInterface {

    void printName();

    // 추후에 추가되는 interface가 있는 경우 상속받는 메소드에서 에러가 발생한다.
//    void printNameUpperCase();
    // 이떄 사용하는 것이 default Method이다.

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnyThing(){
        System.out.println("static FOO");
    }
}
