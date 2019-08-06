package com.wickvood.albumsearch.di.modules;


import com.wickvood.albumsearch.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = RetrofitModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }
}
