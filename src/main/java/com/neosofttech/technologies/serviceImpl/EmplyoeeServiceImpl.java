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

/**
 *
 * @author backup
 */

@Component
public class EmplyoeeServiceImpl implements EmplyoeeService{
    
    @Autowired
    EmplyoeeRepository emprepo;

    public Emplyoee addEmplyoee(Emplyoee emplyoee) {
       return emprepo.save(emplyoee);
    }

    public List<Emplyoee> getAllEmplyoee() {
       return (List<Emplyoee>) emprepo.findAll();       
    }
    
}