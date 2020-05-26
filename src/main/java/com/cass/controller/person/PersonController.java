package com.cass.controller.person;

import com.cass.common.BaseResponse;
import com.cass.person.domain.Person;
import com.cass.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @PreAuthorize("hasAnyAuthority('admin')")
    @RequestMapping("/selectPersonList")
    public BaseResponse<List<Person>> selectPersonList(){
        BaseResponse<List<Person>> baseResponse = new BaseResponse<>();
        baseResponse.setResData(personService.selectPersonList());
        return baseResponse;
    }
}
