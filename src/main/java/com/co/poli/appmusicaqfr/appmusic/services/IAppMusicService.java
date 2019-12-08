package com.co.poli.appmusicaqfr.appmusic.services;

import com.co.poli.appmusicaqfr.appmusic.model.ReproductionList;
import com.co.poli.appmusicaqfr.appmusic.util.Response;

import java.util.ArrayList;

public interface IAppMusicService {
    Response save(ReproductionList reproductionList);
    ArrayList<ReproductionList> getAllReproductionLists();
}
