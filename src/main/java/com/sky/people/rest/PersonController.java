package com.sky.people.rest;

import com.sky.people.dto.PersonDTO;
import com.sky.people.dto.PersonReqDTO;
import com.sky.people.entities.Person;
import com.sky.people.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<PersonDTO> addPerson(@RequestBody @Valid PersonReqDTO person) {  // pulls person from the body of the request
        Person toCreate = new Person(person.getFullName(), person.getOldNess(), person.getOccupation(), person.getNotNiNumber());
        Person created = this.service.createPerson(toCreate);
        PersonDTO dto = new PersonDTO(created.getName(), created.getAge(), created.getJob());

        return new ResponseEntity<PersonDTO>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public String home(){
        return "Hello - has this worked!";
    }
    @GetMapping("/getAll")
    public List<PersonDTO> getAll(){
        List<Person> found = this.service.getAll();
        List<PersonDTO> dtos = new ArrayList<>();
        // For each Person person in found
//        for (Person person : found) dtos.add(new PersonDTO(person.getName(),person.getAge(),person.getJob()));

        //lambda stream converts the list, map iterates the list, collect converts back to list
        return found.stream().map(p -> new PersonDTO(p.getName(),p.getAge(), p.getJob())).collect(Collectors.toList());

//        return dtos;

    }

    @GetMapping("/get/{id}") // pulls id from the path (url)
    public PersonDTO getPerson(@PathVariable int id){
        Person found = this.service.getById(id);
        PersonDTO dto = new PersonDTO(found.getName(), found.getAge(), found.getJob());
        return dto;
    }

    @PatchMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable int id, @PathParam("name") String name,@PathParam("age") Integer age,@PathParam("job") String job){
        Person update = this.service.update(id,name,age,job);
        PersonDTO dto = new PersonDTO(update.getName(), update.getAge(), update.getJob());
        return dto;
    }

    @DeleteMapping("/remove/{id}")
    public PersonDTO removePerson(@PathVariable int id){
        Person remove = this.service.remove(id);
        PersonDTO dto = new PersonDTO(remove.getName(), remove.getAge(), remove.getJob());
        return dto;
    }

}
