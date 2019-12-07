package com.co.poli.appmusicaqfr.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class StatusController {
    @GetMapping("/status")
    public String status(){
        return "Running server";
    }
}
