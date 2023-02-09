package com.sky.people.rest;

import com.sky.people.entities.Person;
import com.sky.people.service.PersonService;
import com.sky.people.service.PersonServiceDB;
import com.sky.people.service.PersonServiceList;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    // the service variable is a dependency
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(){
        return "Hello, Steve!";
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) {  // pulls person from the body of the request

    }

    @GetMapping("/getAll")
    public List<Person> getAll(){

    }

    @GetMapping("/get/{id}") // pulls id from the path (url)
    public Person getPerson(@PathVariable int id){

    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id){

    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @PathParam("name") String name,@PathParam("age") Integer age,@PathParam("job") String job){

    }


}
