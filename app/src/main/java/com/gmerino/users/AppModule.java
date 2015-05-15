package com.gmerino.users;

import android.content.Context;

import com.gmerino.users.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Guille on 15/05/2015.
 */
@Module(
        injects = {
                App.class
        }
)
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

//    @Provides
//    @Singleton
//    public Context provideApplicationContext() {
//        return app;
//    }
}