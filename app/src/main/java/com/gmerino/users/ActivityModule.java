package com.gmerino.users;

import android.content.Context;

import com.gmerino.users.presenter.UserDetailPresenter;
import com.gmerino.users.presenter.UserDetailPresenterMock;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.presenter.UserListPresenterMock;
import com.gmerino.users.view.activity.UserDetailActivity;
import com.gmerino.users.view.activity.UserListActivity;
import com.gmerino.users.view.fragment.UserDetailFragment;
import com.gmerino.users.view.fragment.UserListFragment;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = {UserListFragment.class,
        UserListActivity.class,
        UserDetailActivity.class,
        UserDetailFragment.class},
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
    UserListPresenter provideUserListPresenter(){
        UserListPresenterMock presenter = new UserListPresenterMock();
        return presenter;
    }

    @Provides
    UserDetailPresenter provideUserDetailPresenter(){
        UserDetailPresenter presenter = new UserDetailPresenterMock();
        return presenter;
    }
}
