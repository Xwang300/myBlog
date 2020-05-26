package com.cass.person.service.impl;


import com.cass.person.domain.Person;
import com.cass.person.mapper.PersonMapper;
import com.cass.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> selectPersonList() {
        return personMapper.selectPersonList();
    }

    @Override
    public Person selectPersonById(Integer id) {
        return personMapper.selectPersonById(id);
    }

    @Override
    public Integer insertPerson(Person person) {
        return personMapper.insertPerson(person);
    }

    @Override
    public Integer updatePerson(Person person) {
        return personMapper.updatePerson(person);
    }

    @Override
    public Integer deletePersonById(Integer id) {
        return personMapper.deletePersonById(id);
    }
}
