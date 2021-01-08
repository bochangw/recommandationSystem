package com.bowang.recommandationSystem.controller;

import com.bowang.recommandationSystem.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @GetMapping(path="/", produces = "application/json")
    public User getEmployees()
    {
        return new User("Bochang", "Wang", "123");
    }
}
