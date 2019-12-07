package com.co.poli.appmusicaqfr.appmusic.services.impl;

import com.co.poli.appmusicaqfr.appmusic.dao.IAppMusicDao;
import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.services.IAppMusicService;
import com.co.poli.appmusicaqfr.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AppMusicServiceServiceImpl implements IAppMusicService {

    @Autowired
    private IAppMusicDao appMusicDao;

    @Override
    @Transactional
    public Response save(ReproductionList saveReproductionList) {
        Response message = new Response();
        if(saveReproductionList.getName() == null ){
            message.setState(false);
            message.setCodeMessage(400);
            message.setMessage("Bad Request");
        }else{
            message.setState(true);
            message.setCodeMessage(201);
            message.setMessage("Created");
            message.setMessageBody(saveReproductionList);
        }
        return message;
        //return appMusicDao.save(saveReproductionList);
    }
}
