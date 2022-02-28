package com.innova.project.controller;

import com.innova.project.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {
    @Autowired
    CreditService creditService;

    @GetMapping("/credit/{tckn}")
    public String credit(@PathVariable Long tckn){
        return creditService.credit(tckn);
    }
}
