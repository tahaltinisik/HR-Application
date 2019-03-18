/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.repositories;

import com.toa.hrapplication.models.Job;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TAHA'S BEAST
 */

public interface JobRepository extends CrudRepository<Job, Long> {

}