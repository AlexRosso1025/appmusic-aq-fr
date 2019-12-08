package com.co.poli.appmusicaqfr.appmusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String status(){
        return "This is Working";
    }
}
