package com.wickvood.albumsearch;

import com.wickvood.albumsearch.mvp.model.AlbumResultModel;
import com.wickvood.albumsearch.mvp.model.SongResultModel;

import retrofit2.Call;


public class NetworkService {

    private Api api;

    public NetworkService(Api api) {
        this.api = api;
    }

    public Call<AlbumResultModel> getAlbums(String term){
        return  api.getAlbums(term,Api.ENTITY_ALBUM);
    }

    public Call<SongResultModel> getSongByAlbumId(int albumId){
        return api.getSongs(albumId,Api.ENTITY_SONG);
    }
}
