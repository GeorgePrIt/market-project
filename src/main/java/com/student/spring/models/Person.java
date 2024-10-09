package com.student.spring.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max =30, message = "Name should be between 2 and a30 characters")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 3, max =30, message = "Surname should be between 3 and a30 characters")
    private String surname;

    @Min(value = 1, message = "Age should be greater than 0")
    @Max(value= 100, message = "Age cannot be more than 100")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;


    public Person(int id, String name,  String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public Person(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
