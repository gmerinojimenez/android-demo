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
