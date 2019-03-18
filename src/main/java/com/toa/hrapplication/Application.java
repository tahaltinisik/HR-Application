/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication;

import com.toa.hrapplication.models.Job;
import com.toa.hrapplication.repositories.JobRepository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author TAHA'S BEAST
 */

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(JobRepository repository) {
		return (args) -> {
			// save a couple of jobs
			repository.save(new Job("Job1", "Desc1",1, new Date()));
			repository.save(new Job("Job2", "Desc2",2, new Date()));
			repository.save(new Job("Job3", "Desc3",3, new Date()));
			repository.save(new Job("Job4", "Desc4",4, new Date()));
			repository.save(new Job("Job5", "Desc5",5, new Date()));
		};
	}

}