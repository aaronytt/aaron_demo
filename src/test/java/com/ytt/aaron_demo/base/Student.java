package com.ytt.aaron_demo.base;

import java.lang.reflect.Field;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:13 2019/3/15
 * @Modiflid By:
 */
public class Student extends Person {

    private String name;

    private int age;

    public Student() {
        System.out.println("s()");
    }

    public Student(String name, int age) {
        super(name,age);
        System.out.println("s(...)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {

        Student s = new Student("name",0);
        Person p = s;
        s.setName("name.1");
        p.setName("name.2");
        p.setAge(2);
        s.setAge(1);

        System.out.println(s.toString());
        System.out.println(p.toString());

        Class sc = s.getClass();

        for (Field f : sc.getDeclaredFields()) {
            System.out.println(f.get(s));
        }

        Class pc = p.getClass().getSuperclass();

        for (Field f : pc.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.get(p));
        }

    }

}

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:13 2019/3/15
 * @Modiflid By:
 */
class Person {

    private String name;

    private int age;

    public Person() {
        System.out.println("p()");
    }

    public Person(String name, int age) {
        System.out.println("p(...)");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
