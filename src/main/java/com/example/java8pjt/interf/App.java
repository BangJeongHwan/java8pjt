package com.example.java8pjt.interf;

public class App {
    public static void main(String[] args) {
        FooInterface fooInterface = new DefaultFoo("jeong");
        System.out.println(fooInterface.getName());
        fooInterface.printNameUpperCase();

        FooInterface.printAnyThing();
    }
}
