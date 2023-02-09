package com.sky.people.rest;

import com.sky.people.entities.Person;
import com.sky.people.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

//@autowired -> also injects the dependancy but constructor is better.
@RestController
public class PersonController {
    // the service variable is a dependency
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String greeting(){
//        return "Hello, Steve!";
//    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) {  // pulls person from the body of the request
        return this.service.createPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/get/{id}") // pulls id from the path (url)
    public Person getPerson(@PathVariable int id){
        return this.service.getById(id);
    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @PathParam("name") String name,@PathParam("age") Integer age,@PathParam("job") String job){
        return this.service.update(id,name,age,job);
    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id){
        return this.service.remove(id);
    }

}
