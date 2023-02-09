package com.sky.people.persistence;

import com.sky.people.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface PersonRepo extends JpaRepository<Person, Integer > {
}
