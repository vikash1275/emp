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
    public   Attendance  addAttendance(Attendance attendance) {
       return attendrep.save(attendance);
    }

   @Override
    public List<Attendance> getAllAttendance() {
       return (List<Attendance>) attendrep.findAll();
    }
    
    
         
}
