/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.dto;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author backup
 */

@Entity
public class Attendance 
{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
           
    private String day;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date utilDate;
     
    public Attendance() {
    }

    @OneToOne(cascade = CascadeType.MERGE)
    private Employee emp;  

    public Attendance(int id, String day, Employee emp) {
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

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }
    
    
    
  
}
