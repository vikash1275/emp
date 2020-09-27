/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.controller;

import com.neosofttech.technologies.dto.Employee;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.neosofttech.technologies.service.EmployeeService;
import com.neosofttech.technologies.repository.EmployeeRepository;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author backup
 */

@RestController
@RequestMapping("/Webflux")
public class WebfluxRestController 
{
        
    @Autowired
    private EmployeeService empserv;
    
      
    @GetMapping("/getAllEmplyoee")
    public Flux<Employee> getAllEmplyoee()
    {         
       return empserv.getAllEmplyoee();
    }
    
    @PostMapping("/addEmplyoee")
    public Mono<Employee> addEmplyoee(@RequestBody Employee emplyoee)
    {
            return  empserv.addEmplyoee(emplyoee);
    }
    
    @GetMapping("/getEmplyoeeById/{id}")
    public Mono<Employee> getEmplyoeeById(@PathVariable int id)
    {         
       return empserv.getById(id);
    }
    
    @DeleteMapping(value = "/employees/{id}")
    public Mono<String> deleteEmployeeById(@PathVariable("id") int id) {
        return empserv.deleteEmployeeById(id);
    }
    
    
    /*
    @PostMapping("/addEmplyoee")
    public ResponseEntity<Object> addEmplyoee(@RequestBody Emplyoee emplyoee)
    {	    	
    	empserv.addEmplyoee(emplyoee);
        URI path= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("(emplyoee)")
                .buildAndExpand(emplyoee.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    */
        
}
