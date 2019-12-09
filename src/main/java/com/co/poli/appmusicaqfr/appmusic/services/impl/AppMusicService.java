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

    @Override
    @Transactional
    public Response getDescription(String listName) {
        Response response = new Response();
        String _listName;
        String _description;
        boolean band=false;
        for(ReproductionList list: appMusicDao.findAll()){
            _listName=list.getName();
            if(_listName.equals(listName)){
                band=true;
                if(band){
                    _description=list.getDescription();
                    response.setState(true);
                    response.setMessage("Ok");
                    response.setMessageBody(_description);
                }
            }else{
                response.setState(false);
                response.setCodeMessage(404);
                response.setMessage("Not Found");
            }
        }
        return response;
    }

    @Override
    @Transactional
    public Response modifyReproductionList(String listName, ReproductionList reproductionList) {
        String _listName;
        String _listDescription;
        boolean band=false;
        Response response = new Response();
        for(ReproductionList list: appMusicDao.findAll()){
            _listName=list.getName();
            if(_listName.equals(listName)){
                band=true;
                if(band){
                    if(_listName.equals(list.getName()) && _listName.equals(reproductionList.getName())){
                        _listDescription=reproductionList.getDescription();
                        list.setDescription(_listDescription);
                        response.setState(true);
                        response.setCodeMessage(204);
                        response.setMessage("No content");
                        response.setMessageBody(appMusicDao.save(reproductionList));
                    }else{
                        response.setState(false);
                        response.setCodeMessage(409);
                        response.setMessage("Conflit");
                    }
                }
            }else{
                response.setState(false);
                response.setCodeMessage(404);
                response.setMessage("Not Found");
            }
        }
        return response;
    }

    @Override
    @Transactional
    public Response deleteReproductionList(String listName) {
        String _listName;
        boolean band=false;
        Response response = new Response();
        for (ReproductionList list: appMusicDao.findAll()){
            _listName=list.getName();
            if(_listName.equals(listName)){
                band=true;
                if(band){
                    appMusicDao.deleteById(_listName);
                    response.setState(true);
                    response.setCodeMessage(204);
                    response.setMessage("No content");
                }
            }
            else{
                response.setState(false);
                response.setCodeMessage(404);
                response.setMessage("Not Found");
            }
        }
        return response;
    }
}
