package com.neueda.spring_mongodb_example.service;

import com.neueda.spring_mongodb_example.documents.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Person insertPerson(Person person) {
        return mongoTemplate.insert(person);
    }

    public Person findPersonById(String id) {
        return mongoTemplate.findById(id, Person.class);
    }
}
