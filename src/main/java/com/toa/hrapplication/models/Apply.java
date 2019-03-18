/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.models;

import static java.sql.JDBCType.BLOB;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
/**
 *
 * @author TAHA'S BEAST
 */
@Entity
public class Apply {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long jobId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String thoughtsOnJob;
    @Lob
    private byte[] resume;
    
    public Apply(Long jobId, String name, String email, String phone, String address, String thoughtsOnJob, byte[] resume ) {
        this.jobId = jobId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.thoughtsOnJob = thoughtsOnJob;
        this.resume = resume;
    }

    public Apply() {
        this(Long.MIN_VALUE, "","","","","", new byte[0]);
    }
    
    @Override
    public String toString() {
        return String.format("Apply[id=%d, name='%s', email='%s', phone='%s', address='%s', thoughtsOnJob='%s']", getId(), getName(), getEmail(), getPhone(), getAddress(), getThoughtsOnJob());
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the thoughtsOnJob
     */
    public String getThoughtsOnJob() {
        return thoughtsOnJob;
    }

    /**
     * @param thoughtsOnJob the thoughtsOnJob to set
     */
    public void setThoughtsOnJob(String thoughtsOnJob) {
        this.thoughtsOnJob = thoughtsOnJob;
    }

    /**
     * @return the resume
     */
    public byte[] getResume() {
        return resume;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    /**
     * @return the jobId
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
