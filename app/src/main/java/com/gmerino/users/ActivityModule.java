package com.gmerino.users;

import android.content.Context;

import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.presenter.UserListPresenterMock;
import com.gmerino.users.view.activity.UserListActivity;
import com.gmerino.users.view.fragment.UserListFragment;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = {UserListFragment.class,
        UserListActivity.class},
        library = true, complete = false)
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
    UserListPresenter provideUserListPresenter(){
        UserListPresenterMock presenter = new UserListPresenterMock();
        return presenter;
    }
}
