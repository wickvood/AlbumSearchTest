package com.wickvood.albumsearch.di;

import android.content.Context;

import com.wickvood.albumsearch.di.modules.ContextModule;
import com.wickvood.albumsearch.di.modules.NetworkServiceModule;
import com.wickvood.albumsearch.di.modules.RetrofitModule;
import com.wickvood.albumsearch.mvp.presenter.AlbumDetailPresenter;
import com.wickvood.albumsearch.mvp.presenter.AlbumPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        RetrofitModule.class,
        NetworkServiceModule.class
})

public interface AppComponent {

    Context getContext();

    void inject(AlbumPresenter presenter);
    void inject(AlbumDetailPresenter presenter);
}
