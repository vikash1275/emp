/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.repository;

import com.neosofttech.technologies.dto.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

 /**
 *
 * @author backup
 */

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer>{
    
}
