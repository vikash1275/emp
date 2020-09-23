/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author backup
 */

@Entity
public class Attendance 
{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
           
    private String day;

    public Attendance() {
    }
              
    @OneToOne(cascade = CascadeType.ALL)
    private Emplyoee emp;  

    public Attendance(Long id, String day, Emplyoee emp) {
        this.id = id;
        this.day = day;
        this.emp = emp;   
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Emplyoee getEmp() {
        return emp;
    }

    public void setEmp(Emplyoee emp) {
        this.emp = emp;
    }
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
}
