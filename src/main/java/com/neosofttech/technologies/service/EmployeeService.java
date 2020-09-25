 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.neosofttech.technologies.service;

import com.neosofttech.technologies.dto.Employee;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

 /**
 *
 * @author backup
 */



@Service
public interface EmployeeService {
    
	public Mono<Employee> addEmplyoee(Employee emplyoee);
	public Flux<Employee> getAllEmplyoee();	
      
}