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
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;

/**
 *
 * @author backup
 */

@Component
public class EmployeeServiceImpl implements EmployeeService
{
    
    @Autowired
    private EmployeeRepository emprepo;
    
       
    public Mono<Employee> addEmplyoee(Employee emplyoee) {
                return Mono.just(emprepo.save(emplyoee));
    }

    public Flux<Employee> getAllEmplyoee() {
                return Flux.fromIterable(emprepo.findAll());             
    }
    
    public Mono<Employee> getById(int id) { 
             Mono<Optional<Employee>> optional = Mono.just(emprepo.findById(id));
             Mono<Employee> optionalmono = optional.flatMap(Mono::justOrEmpty);
             return optionalmono;
    }

    public Mono<String> deleteEmployeeById(int id) {
             emprepo.deleteById(id);
             String message="deleted";     
             return Mono.justOrEmpty(message);
    }

    public Mono<Employee> update(int id, final Employee employee) {
             return Mono.just(emprepo.save(employee));                   
        
    }
    
    

    
  
    
    
    
    
    
}
