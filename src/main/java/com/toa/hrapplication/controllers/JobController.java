/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.controllers;

import com.toa.hrapplication.models.Apply;
import com.toa.hrapplication.models.Job;
import com.toa.hrapplication.repositories.JobRepository;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TAHA'S BEAST
 */

@Controller
public class JobController {
    private final JobRepository jobRepository;
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    
    @GetMapping("/jobs")
    public String index(Authentication authentication, Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("isHrManager", isHRManager(authentication));
        return "jobs/index";
    }
    
    @RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET)
    public String details(Authentication authentication, Model model, @PathVariable String jobId) {
        try{
            Long jobIdL = Long.parseLong(jobId);
            model.addAttribute("job", jobRepository.findById(jobIdL).get());
            model.addAttribute("isHrManager", isHRManager(authentication));
            
            Apply apply = new Apply();
            apply.setJobId(jobIdL);
            model.addAttribute("apply", apply);
            return "jobs/details";
        } catch(NumberFormatException e){ }
        return "redirect:/jobs";
    }
    
    @GetMapping("/jobs/create")
    public String create(Model model) {
        model.addAttribute("job", new Job());
        return "jobs/create";
    }

    @PostMapping("/jobs/create")
    public String createSubmit(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/jobs";
    }
    
    @RequestMapping(value = "/jobs/delete/{jobId}", method = RequestMethod.GET)
    public String delete(@PathVariable String jobId) {
        try{
            jobRepository.deleteById(Long.parseLong(jobId));
        } catch(NumberFormatException e){ }
        return "redirect:/jobs";
    }
    
    private boolean isHRManager(Authentication authentication){
        if(authentication == null) return false;
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            if(auth.getAuthority().equalsIgnoreCase("ROLE_HRMANAGER")) return true;
        }
        
        return false;
    }
}
