package com.cass.person;


import com.cass.blog.BlogApplication;
import com.cass.person.domain.Person;
import com.cass.person.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest(classes = {BlogApplication.class})
public class PersonTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void selectPersonList(){
        List<Person> personList = personMapper.selectPersonList();
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
