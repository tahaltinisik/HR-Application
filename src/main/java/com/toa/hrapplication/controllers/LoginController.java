/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toa.hrapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author TAHA'S BEAST
 */
@Controller
public class LoginController {
    
    @PostMapping("/loginfw")
    public String forward(Model model) {
        return "redirect:/jobs";
    }    
}
