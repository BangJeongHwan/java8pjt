package com.example.java8pjt;


public class Foo {

    @FunctionalInterface
    public interface RunSomething {

        void doIt();
    }

    @FunctionalInterface
    public interface RunSomething1 {

        int doIt1(int number);
    }
    public static void main(String[] args) {

        // 익명 내부 클래스 annoymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        // 위와 동일한 형식을 람다 형식으로 변환
//        RunSomething runSomething = () -> System.out.println("Hello");
//        runSomething.doIt();

        // 메소드 안에 두개 이상일 경우
//        RunSomething runSomething2 = () -> {
//            System.out.println("Hello");
//            System.out.println("lambda");
//        };

        // 반환 값이 있는 경우
        // 항상 같은 값을 반환해야 한다.
//        RunSomething1 runSomething1 = (number) -> number+10;
//        int result = runSomething1.doIt1(1);
//        System.out.println("result = " + result);
//        int result1 = runSomething1.doIt1(1);
//        System.out.println("result1 = " + result1);
//        int result2 = runSomething1.doIt1(1);
//        System.out.println("result2 = " + result2);
//        int result3 = runSomething1.doIt1(1);
//        System.out.println("result3 = " + result3);
//        int result4 = runSomething1.doIt1(1);
//        System.out.println("result4 = " + result4);

        int localNumber = 10;
        RunSomething1 runSomething1 = new RunSomething1() {
            @Override
            public int doIt1(int number) {
                return number+localNumber;
            }
        };
        int result = runSomething1.doIt1(1);
        System.out.println("result = " + result);

        // 익명 내부 클래스 안에 있는 변수 값은 변경할 수 없다.
//        localNumber++;

    }


}
