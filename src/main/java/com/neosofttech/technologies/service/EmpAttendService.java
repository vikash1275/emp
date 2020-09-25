/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.service;

import com.neosofttech.technologies.dto.Attendance;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author backup
 */

@Service
public interface EmpAttendService 
{
public Mono<Attendance> addAttendance(Attendance attendance);
public Flux<Attendance> getAllAttendance();
public Mono<Attendance> getById(int id);

}
