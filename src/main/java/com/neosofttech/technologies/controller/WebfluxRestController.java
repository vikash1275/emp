/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.controller;

import com.neosofttech.technologies.dto.Emplyoee;
import com.neosofttech.technologies.repository.EmplyoeeRepository;
import com.neosofttech.technologies.service.EmplyoeeService;
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

/**
 *
 * @author backup
 */

@RestController
@RequestMapping("/Webflux")
public class WebfluxRestController 
{
    
    @Autowired
    private EmplyoeeService empserv;
    
    @GetMapping("/getAllEmplyoee")
    public Iterable<Emplyoee> getAllPolicy()
    {    
             return empserv.getAllEmplyoee();       
    }
    
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
        
}
