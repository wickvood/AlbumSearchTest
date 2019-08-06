package com.wickvood.albumsearch.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.wickvood.albumsearch.mvp.model.SongsModel;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AlbumDetailView extends MvpView {


    void showError(String message);

    void hideError();

    void onStartLoading();

    void onFinishLoading();

    void showListProgress();

    void hideListProgress();

    void setSongsModel(List<SongsModel> songsModelList);
}
