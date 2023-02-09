package com.sky.people.entities;

import javax.validation.constraints.*;

public class Person {

    // variables
    @Size(min = 3, max = 50)
    private String name;

    @Min(0)
    @Max(100)
    private int age;

    @NotNull
    private String job;

    // constructors

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    // REQUIRED must have a default constructor and getters and setters for Spring to work!
    public Person(){
    }

    // getters and setters

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
