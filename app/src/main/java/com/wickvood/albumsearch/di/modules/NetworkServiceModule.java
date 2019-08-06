package com.wickvood.albumsearch.di.modules;

import com.wickvood.albumsearch.Api;
import com.wickvood.albumsearch.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiModule.class)
public class NetworkServiceModule {

    @Provides
    @Singleton
    public NetworkService provideNetworkService(Api api){
        return new NetworkService(api);
    }
}
