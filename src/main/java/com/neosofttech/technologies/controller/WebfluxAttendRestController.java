/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.controller;

import com.neosofttech.technologies.dto.Attendance;
import com.neosofttech.technologies.service.EmpAttendService;
import java.net.URI;
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

/**
 *
 * @author backup
 */

@RestController
@RequestMapping("/Attendance")
public class WebfluxAttendRestController {
    
    @Autowired
    private EmpAttendService attedserv;
    
    
    @PostMapping("/addAttendance")
    public Mono<Attendance> addAttendance(@RequestBody Attendance attendance)
    {
            return  attedserv.addAttendance(attendance);
    }
    
    @GetMapping("/getAllAttendance")
    public Iterable<Attendance> getAllAttendance()
    {            
             return attedserv.getAllAttendance();
    }
    
    /**
     *
     * @return
     */
  
  /*  
    @PostMapping("/addAttendance")
    public ResponseEntity<Object> addAttendance(@RequestBody Attendance attendance)
    {	    	
    	attedserv.addAttendance(attendance);
        URI path= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("(emplyoee)")
                .buildAndExpand(attendance.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
*/
    
}
