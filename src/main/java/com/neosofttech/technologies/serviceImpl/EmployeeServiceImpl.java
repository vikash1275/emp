/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.serviceImpl;

import com.neosofttech.technologies.dto.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.neosofttech.technologies.service.EmployeeService;
import com.neosofttech.technologies.repository.EmployeeRepository;

/**
 *
 * @author backup
 */

@Component
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepository emprepo;
    
    Employee emp = new Employee();
       
    public Mono<Employee> addEmplyoee(Employee emplyoee) {
       return Mono.just(emprepo.save(emplyoee));
    }

    public Flux<Employee> getAllEmplyoee() {
               return Flux.fromIterable(emprepo.findAll());             
    }
    
}
