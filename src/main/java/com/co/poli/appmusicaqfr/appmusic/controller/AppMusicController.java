package com.co.poli.appmusicaqfr.appmusic.controller;

import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.services.IAppMusicService;
import com.co.poli.appmusicaqfr.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/lists/{name}")
    public Response getListDescription(@PathVariable(value="name") String listName) {
        return appMusicService.getDescription(listName);
    }

    @PutMapping("lists/{name}")
    public Response modifyReproductionList(@PathVariable(value = "name") String listName, @RequestBody ReproductionList reproductionList){
        return appMusicService.modifyReproductionList(listName,reproductionList);
    }

    @DeleteMapping("lists/{name}")
    public Response deleteReproductionList(@PathVariable(value = "name") String listName){
        return appMusicService.deleteReproductionList(listName);
    }

}
