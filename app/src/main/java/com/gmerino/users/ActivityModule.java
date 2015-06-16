package com.gmerino.users;

import android.content.Context;

import com.gmerino.users.interactor.LoadUser;
import com.gmerino.users.interactor.LoadUserImpl;
import com.gmerino.users.interactor.LoadUsers;
import com.gmerino.users.interactor.LoadUsersImpl;
import com.gmerino.users.interactor.PersistUser;
import com.gmerino.users.interactor.PersistUserImpl;
import com.gmerino.users.presenter.UserDetailPresenter;
import com.gmerino.users.presenter.UserDetailPresenterImpl;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.presenter.UserListPresenterImpl;
import com.gmerino.users.view.activity.UserDetailActivity;
import com.gmerino.users.view.activity.UserListActivity;
import com.gmerino.users.view.fragment.UserDetailFragment;
import com.gmerino.users.view.fragment.UserListFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

@Module(injects = {UserListFragment.class,
        UserListActivity.class,
        UserDetailActivity.class,
        UserDetailFragment.class,
        UserListPresenterImpl.class},
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
    UserListPresenter provideUserListPresenter(LoadUsers loadUsers, PersistUser persistUser) {
        UserListPresenter presenter = new UserListPresenterImpl(loadUsers, persistUser);
        return presenter;
    }

    @Provides
    UserDetailPresenter provideUserDetailPresenter(LoadUser loadUser) {
        UserDetailPresenter presenter = new UserDetailPresenterImpl(loadUser);
        return presenter;
    }


    @Provides
    LoadUsers provideLoadUsers(LoadUsersImpl impl){
        return impl;
    }

    @Provides
    LoadUser provideLoadUser(LoadUserImpl impl){
        return impl;
    }

    @Provides
    PersistUser providePersistUser(PersistUserImpl impl) {
        return impl;
    }
}
