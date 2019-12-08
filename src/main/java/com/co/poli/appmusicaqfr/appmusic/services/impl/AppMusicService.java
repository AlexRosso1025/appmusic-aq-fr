package com.co.poli.appmusicaqfr.appmusic.services.impl;

import com.co.poli.appmusicaqfr.appmusic.dao.IAppMusicDao;
import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.services.IAppMusicService;
import com.co.poli.appmusicaqfr.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class AppMusicService implements IAppMusicService {

    @Autowired
    private IAppMusicDao appMusicDao;

    @Override
    @Transactional
    public Response save(ReproductionList reproductionList) {
        Response response = new Response();
        if(reproductionList.getName()==null || reproductionList.getName().isEmpty()){
            response.setState(false);
            response.setMessage("Bad Request");
            response.setCodeMessage(400);
            response.setMessageBody("Error");
        }else{
            response.setMessage("Created");
            response.setCodeMessage(201);
            response.setState(true);
            response.setMessageBody(appMusicDao.save(reproductionList));
        }
        return response;
    }

    @Override
    @Transactional
    public ArrayList<ReproductionList> getAllReproductionLists() {
        ArrayList<ReproductionList> reproductionLists  = new ArrayList<>();
        for (ReproductionList list: appMusicDao.findAll()){
            reproductionLists.add(list);
        }
        return reproductionLists;
    }
}