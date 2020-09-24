/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.serviceImpl;

import com.neosofttech.technologies.dto.Emplyoee;
import com.neosofttech.technologies.repository.EmplyoeeRepository;
import com.neosofttech.technologies.service.EmplyoeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 *
 * @author backup
 */

@Component
public class EmplyoeeServiceImpl implements EmplyoeeService{
    
    @Autowired
    private EmplyoeeRepository emprepo;
    
    Emplyoee emp = new Emplyoee();
       
    public Mono<Emplyoee> addEmplyoee(Emplyoee emplyoee) {
       return Mono.just(emprepo.save(emplyoee));
    }

    public List<Emplyoee> getAllEmplyoee() {
       return (List<Emplyoee>) emprepo.findAll();       
    }
    
}
