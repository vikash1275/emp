/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.service;

import com.neosofttech.technologies.dto.Emplyoee;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author backup
 */



@Service
public interface EmplyoeeService {
    
	public Emplyoee addEmplyoee(Emplyoee emplyoee);
	public List<Emplyoee> getAllEmplyoee();	
}