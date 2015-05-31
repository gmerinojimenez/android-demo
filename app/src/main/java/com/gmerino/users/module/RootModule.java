package com.gmerino.users.module;

import android.content.Context;

import com.gmerino.commons.ThreadPool;
import com.gmerino.users.App;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.presenter.UserListPresenterMock;

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

    @Provides
    @Singleton
    ThreadPool provideThreadPool() {
        return new ThreadPool();
    }

}
