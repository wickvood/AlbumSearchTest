package com.wickvood.albumsearch;

import com.wickvood.albumsearch.mvp.model.AlbumResultModel;
import com.wickvood.albumsearch.mvp.model.SongResultModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://itunes.apple.com/";
    String ENTITY_ALBUM = "album";
    String ENTITY_SONG = "song";


    @GET("search")
    Call<AlbumResultModel> getAlbums(
            @Query("term") CharSequence search,
            @Query("entity") String entity
    );

    @GET("lookup")
    Call<SongResultModel> getSongs(
            @Query("id") int idAlbum,
            @Query("entity")  String entity
    );

}
