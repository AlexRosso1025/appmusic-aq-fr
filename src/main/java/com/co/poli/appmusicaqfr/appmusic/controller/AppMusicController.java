package com.co.poli.appmusicaqfr.appmusic.controller;

import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.services.IAppMusicService;
import com.co.poli.appmusicaqfr.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AppMusicController {
    @Autowired
    IAppMusicService appMusicService;

    @PostMapping("/lists")
    public Response addReproductionList(@RequestBody ReproductionList reproductionList){
        return appMusicService.save(reproductionList);
    }

    @GetMapping("/lists")
    public ArrayList<ReproductionList> getLists(){
        return appMusicService.getAllReproductionLists();
    }

}
