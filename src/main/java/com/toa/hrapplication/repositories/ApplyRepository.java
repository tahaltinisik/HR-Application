/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.repositories;

import com.toa.hrapplication.models.Apply;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TAHA'S BEAST
 */
public interface ApplyRepository extends CrudRepository<Apply, Long> {
    List<Apply> findByJobId(Long jobId);
}
