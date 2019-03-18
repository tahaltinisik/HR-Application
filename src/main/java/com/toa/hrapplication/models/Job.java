/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author TAHA'S BEAST
 */

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Integer numberOfPeopleToHire;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastApplicationDate;
    
    public Job(String title, String description, Integer numberOfPeopleToHire, Date lastApplicationDate) {
        this.title = title;
        this.description = description;
        this.numberOfPeopleToHire = numberOfPeopleToHire;
        this.lastApplicationDate = lastApplicationDate;
    }

    public Job() {
        this("","",0, new Date());
    }

    @Override
    public String toString() {
        return String.format("Job[id=%d, title='%s', description='%s', numberOfPeopleToHire='%d', lastApplicationDate='%d']", getId(), getTitle(), getDescription(), getNumberOfPeopleToHire(), getLastApplicationDate());
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the numberOfPeopleToHire
     */
    public Integer getNumberOfPeopleToHire() {
        return numberOfPeopleToHire;
    }

    /**
     * @return the lastApplicationDate
     */
    public Date getLastApplicationDate() {
        return lastApplicationDate;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param numberOfPeopleToHire the numberOfPeopleToHire to set
     */
    public void setNumberOfPeopleToHire(Integer numberOfPeopleToHire) {
        this.numberOfPeopleToHire = numberOfPeopleToHire;
    }

    /**
     * @param lastApplicationDate the lastApplicationDate to set
     */
    public void setLastApplicationDate(Date lastApplicationDate) {
        this.lastApplicationDate = lastApplicationDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

}