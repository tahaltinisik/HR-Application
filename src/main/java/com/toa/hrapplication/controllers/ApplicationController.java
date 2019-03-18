/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.controllers;

import com.toa.hrapplication.models.Apply;
import com.toa.hrapplication.repositories.ApplyRepository;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TAHA'S BEAST
 */
@Controller
public class ApplicationController {
    
    private final ApplyRepository applyRepository;
    
    public ApplicationController(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }
    
    @RequestMapping(value = "/applications/jobId={jobId}", method = RequestMethod.GET)
    public String byJobId(Authentication authentication, Model model, @PathVariable String jobId) {
        try{
            Long jobIdL = Long.parseLong(jobId);
            model.addAttribute("applies", applyRepository.findByJobId(jobIdL));
            model.addAttribute("jobId", jobIdL);
            return "applications/index";
        } catch(NumberFormatException e){ }
        return "redirect:/jobs";
    }

    @RequestMapping(value = "/applications/details/{applyId}", method = RequestMethod.GET)
    public String details(Authentication authentication, Model model, @PathVariable String applyId) {
        try{
            model.addAttribute("apply", applyRepository.findById(Long.parseLong(applyId)).get());
            return "applications/details";
        } catch(NumberFormatException e){ }
        return "redirect:/jobs";
    }
    
    @RequestMapping(value="/applications/resume/{applyId}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> resume(@PathVariable String applyId) {
        byte[] pdfBytes = new byte[0];
        try{
            Apply apply = applyRepository.findById(Long.parseLong(applyId)).get();
            pdfBytes = apply.getResume();
        } catch(NumberFormatException e){ }
        String filename = "resume"+applyId+".pdf";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.add("content-disposition", "inline;filename=" + filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdfBytes, headers, HttpStatus.OK);
        return response;    
        
    }
    
    @PostMapping("/applications/create")
    public String createSubmit(@RequestParam("file") MultipartFile file, @ModelAttribute Apply apply) {
        try {
            apply.setResume(file.getBytes());
        } catch (IOException ex) { }
        applyRepository.save(apply);
        return "redirect:/jobs/"+apply.getJobId();
    }
}
