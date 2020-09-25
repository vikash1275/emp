/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.serviceImpl;

import com.neosofttech.technologies.dto.Attendance;
import com.neosofttech.technologies.repository.AttendanceRepository;
import com.neosofttech.technologies.service.EmpAttendService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author backup
 */

@Component
public class EmpAttendServiceImpl implements EmpAttendService   
{

    @Autowired
    AttendanceRepository attendrep;
    
    @Override
    public  Mono<Attendance>  addAttendance(Attendance attendance) {
       return Mono.just(attendrep.save(attendance));
    }
    
    @Override
    public Flux<Attendance> getAllAttendance() {
           return Flux.fromIterable(attendrep.findAll());             
    }

    @Override
    public Mono<Attendance> getById(int id) {
         Mono<Optional<Attendance>> optional = Mono.just(attendrep.findById(id));
             Mono<Attendance> optionalmono = optional.flatMap(Mono::justOrEmpty);
             return optionalmono;
    }
    
         
}
