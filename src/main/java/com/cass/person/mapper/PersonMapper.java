package com.cass.person.mapper;

import com.cass.person.domain.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonMapper {

    public Person selectPersonById(Integer id );

    public List<Person> selectPersonList();

    public Integer insertPerson(Person person);

    public Integer updatePerson(Person person);

    public Integer deletePersonById(Integer id);
}
