package com.cass.person.service;

import com.cass.person.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonService {

    List<Person> selectPersonList();

    Person selectPersonById(Integer id);

    Integer insertPerson(Person person);

    Integer updatePerson(Person person);

    Integer deletePersonById(Integer id);


}
