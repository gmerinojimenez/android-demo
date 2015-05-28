package com.gmerino.users;

import android.content.Context;

import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.view.activity.UserListActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = UserListActivity.class, library = true, complete = false)
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("ActivityContext")
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    @Singleton
    UserListPresenter provideUserListPresenter(UserListPresenter presenter){
        return presenter;
    }
}
