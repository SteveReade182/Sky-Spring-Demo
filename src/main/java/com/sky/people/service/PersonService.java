package com.sky.people.service;

import com.sky.people.entities.Person;

import java.util.List;

public interface PersonService {
    // all public abstract
    Person createPerson (Person p);
    Person getById(int id);
    List<Person> getAll();
    Person update(int id, String name, Integer age, String job);
    Person remove(int id);
}
