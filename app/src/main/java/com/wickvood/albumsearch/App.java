package com.wickvood.albumsearch;

import android.app.Application;

import com.wickvood.albumsearch.di.AppComponent;
import com.wickvood.albumsearch.di.DaggerAppComponent;
import com.wickvood.albumsearch.di.modules.ContextModule;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent(){
        return component;
    }

}
