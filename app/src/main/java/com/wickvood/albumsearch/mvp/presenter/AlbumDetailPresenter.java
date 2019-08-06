package com.wickvood.albumsearch.mvp.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.wickvood.albumsearch.App;
import com.wickvood.albumsearch.NetworkService;
import com.wickvood.albumsearch.mvp.model.SongResultModel;
import com.wickvood.albumsearch.mvp.model.SongsModel;
import com.wickvood.albumsearch.mvp.views.AlbumDetailView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@InjectViewState
public class AlbumDetailPresenter extends MvpPresenter<AlbumDetailView> {

    @Inject
    NetworkService networkService;

    public AlbumDetailPresenter(){
        App.getAppComponent().inject(this);
    }

    public void loadSongs(int albumId){

        getViewState().onStartLoading();

        networkService.getSongByAlbumId(albumId).enqueue(new Callback<SongResultModel>() {
            @Override
            public void onResponse(Call<SongResultModel> call, Response<SongResultModel> response) {
                if (response.code() == 200 && response.isSuccessful()){
                    SongResultModel resultModel = response.body();
                    assert resultModel != null;
                    List<SongsModel> songsModelsList = resultModel.getResults();
                    songsModelsList.remove(0);
                    onLoadingSuccess(songsModelsList);
                } else {
                    getViewState().showError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<SongResultModel> call, Throwable t) {
                onLoadingFailed(t);
            }
        });
    }

    private void onLoadingSuccess(List<SongsModel> songsModelList){
        getViewState().hideListProgress();
        getViewState().setSongsModel(songsModelList);
    }

    private void onLoadingFailed(Throwable error) {
        getViewState().hideListProgress();
        getViewState().showError(error.toString());
    }


    public void onErrorCancel(){
        getViewState().hideError();
    }
}
