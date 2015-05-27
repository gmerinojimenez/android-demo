package com.gmerino.users.module;

import android.content.Context;

import com.gmerino.daggerdemo.DIApplication;
import com.gmerino.daggerdemo.trash.B;
import com.gmerino.daggerdemo.trash.C;
import com.gmerino.users.App;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Guille on 16/05/2015.
 */
@Module(injects = App.class, library = true)
public class RootModule {

    private Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Named("ApplicationContext")
    @Provides
    Context provideApplicationContext() {
        return context;
    }
}
