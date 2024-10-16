package com.student.spring.dao;

import com.student.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static int PEOPLE_COUNT;


    public List<Person> index() {
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from Person where id=?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class))
                .stream().findFirst().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("insert into Person values (1, ?, ?, ?, ?)",
                person.getName(), person.getSurname(), person.getAge(), person.getEmail());
    }
    public void update(int id, Person updatedPerson){
        System.out.println("привет");
        jdbcTemplate.update("update  Person set name=?, surname=?, age=?, email=? where id=?",
                updatedPerson.getName(), updatedPerson.getSurname(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete (int id){
        jdbcTemplate.update("delete from Person where id=?", id);
    }
}

