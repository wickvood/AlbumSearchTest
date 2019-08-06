package com.wickvood.albumsearch.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.wickvood.albumsearch.App;
import com.wickvood.albumsearch.NetworkService;
import com.wickvood.albumsearch.mvp.model.AlbumResultModel;
import com.wickvood.albumsearch.mvp.model.AlbumsModel;
import com.wickvood.albumsearch.mvp.views.AlbumView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@InjectViewState
public class AlbumPresenter extends MvpPresenter<AlbumView> {

    @Inject
    NetworkService networkService;

    private boolean isInLoading;

    public AlbumPresenter() {
        App.getAppComponent().inject(this);
    }


    public void searchAlbum(String query){
        if (isInLoading){
            return;
        }
        isInLoading = true;

        getViewState().onStartLoading();

        networkService.getAlbums(query).enqueue(new Callback<AlbumResultModel>() {
            @Override
            public void onResponse(Call<AlbumResultModel> call, Response<AlbumResultModel> response) {
                if (response.code() == 200 && response.isSuccessful()){
                    AlbumResultModel resultModel = response.body();
                    assert resultModel != null;
                    List<AlbumsModel> albums =  resultModel.getResults();
                    Collections.sort(albums, AlbumsModel.BY_NAME_ALPHABETICAL);
                    onLoadingSuccess (albums);
                } else {
                    getViewState().showError(String.valueOf(response.errorBody()));
                }

            }

            @Override
            public void onFailure(Call<AlbumResultModel> call, Throwable t) {
                onLoadingFailed(t);
            }
        });

    }

    private void onLoadingSuccess(List<AlbumsModel> albumsModelList){
        isInLoading = false;
        getViewState().hideListProgress();
        getViewState().setAlbumsModel(albumsModelList);
    }


    private void onLoadingFailed(Throwable error) {
        isInLoading = false;
        getViewState().hideListProgress();
        getViewState().showError(error.toString());
    }

    public void onErrorCancel() {
        getViewState().hideError();
    }


}
