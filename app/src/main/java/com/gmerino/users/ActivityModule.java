package com.gmerino.users;

import android.content.Context;

import com.gmerino.data.repository.CacheUserRepository;
import com.gmerino.data.repository.RestUserRepository;
import com.gmerino.data.repository.UserRepository;
import com.gmerino.users.interactor.LoadUsers;
import com.gmerino.users.interactor.LoadUsersImpl;
import com.gmerino.users.presenter.UserDetailPresenter;
import com.gmerino.users.presenter.UserDetailPresenterMock;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.presenter.UserListPresenterImpl;
import com.gmerino.users.view.activity.UserDetailActivity;
import com.gmerino.users.view.activity.UserListActivity;
import com.gmerino.users.view.fragment.UserDetailFragment;
import com.gmerino.users.view.fragment.UserListFragment;

import javax.inject.Named;
import javax.inject.Singleton;

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
    UserListPresenter provideUserListPresenter(UserRepository repository, LoadUsers loadUsers) {
        UserListPresenter presenter = new UserListPresenterImpl(repository, loadUsers);
        return presenter;
    }

    @Provides
    UserDetailPresenter provideUserDetailPresenter() {
        UserDetailPresenter presenter = new UserDetailPresenterMock();
        return presenter;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository() {
        RestUserRepository rest = new RestUserRepository();
        CacheUserRepository userRepository = new CacheUserRepository(rest);
        return userRepository;
    }

    @Provides
    LoadUsers provideLoadUsers(LoadUsersImpl impl){
        return impl;
    }

}
