package com.springboot.app.controller;

import com.springboot.app.entities.Person;
import com.springboot.app.service.impl.UserServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personApi")
@Api(tags = "PersonController", description = "PersonController | Rest questions")
public class UserController {

    UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/persons")
    @ApiOperation("Get all persons")
    public List<Person> getAllPersons() {
        return userServiceInterface.getAllUsers();
    }

    @GetMapping("/person/{id}")
    @ApiOperation("Save person")
    public Person getPerson(@PathVariable long id){
        Person person =  userServiceInterface.getUser(id);
        if(person == null){
            System.out.println("There is no Person with id = " + id + " in database");
        }
        return person;
    }

    @PostMapping("/person")
    @ApiOperation("Save person")
    public Person savePerson(@RequestBody Person person){
        userServiceInterface.saveOrUpdateUser(person);
        return person;
    }

    @DeleteMapping("/person/{id}")
    @ApiOperation("Delete person by id")
    public String deletePerson(@PathVariable long id){
        Person person = userServiceInterface.getUser(id);
        if(person == null){
            System.out.println("There is no Person with id = " + id + " in database");
        }
        userServiceInterface.deleteUser(id);
        return "Person with id = " + id + " was delete";
    }
}