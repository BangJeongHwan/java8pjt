package com.example.java8pjt.interf;

public class DefaultFoo implements FooInterface, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    // 디폴트 메소드도 재정의로 할 수 있다.
    // FooInterface 와 Bar에서 공통으로 겹치는 default 매소드가 존재할 경우 아래와 같이 재정의해서 사용할 수 있다.
    @Override
    public void printNameUpperCase() {
        System.out.println("MAX DEFAULT");
    }
}
