package com.co.poli.appmusicaqfr.appmusic.controller;

import com.co.poli.appmusicaqfr.appmusic.dao.IAppMusicDao;
import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.model.Song;
import com.co.poli.appmusicaqfr.appmusic.services.IAppMusicService;
import com.co.poli.appmusicaqfr.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class AppMusicController {
    @Autowired
    IAppMusicService appMusicService;
    /*
    @PostMapping("/lists")
    public ArrayList<Song>  addReproductionList(@RequestBody ReproductionList reproductionList){
        Response response = appMusicService.save(reproductionList);
        if(response.getState()){

        }else{
            response.getMessageBody();
        }
    }*/
    /*@PostMapping("/lists")
    public ResponseEntity addReporList(){
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }*/

    @PostMapping("/lists")
    public ReproductionList addReproductionList(@RequestBody ReproductionList reproductionList){
        Response response = appMusicService.save(reproductionList);
        if(response.getState()){
           return (ReproductionList) response.getMessageBody();
        }else{
            return null;
        }
    }
}
