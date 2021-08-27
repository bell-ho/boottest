package com.drst.soft.boottest.test.dto;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        String str = "str";
        Optional<String> opt = Optional.of(str);    //옵셔널 객체생성
        Optional<String> opt2 = Optional.ofNullable(null);

        String t1 = opt.get();
        System.out.println(t1);

        if (Optional.ofNullable(null).isPresent()) {
            System.out.println(str);
        }

        Person p1 = new Person();
        Person p2 = null;
        Optional<Person> optp = Optional.of(p1);
        Optional<Person> optp2 = Optional.ofNullable(p2);

        if (!optp2.isPresent()) {
            System.out.println("null");
        }

    }
}
class Person{
    String name;
    int age;
}
