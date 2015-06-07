package com.gmerino.users.interactor;

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

import com.domain.user.data.User;
import com.gmerino.commons.Executor;
import com.gmerino.commons.Interactor;
import com.gmerino.data.repository.UserRepository;

import javax.inject.Inject;

import retrofit.android.MainThreadExecutor;

/**
 * Created by Guille on 04/06/2015.
 */
public class LoadUserImpl implements Interactor, LoadUser{

    private final Executor executor;
    private final MainThreadExecutor mainThreadExecutor;
    private final UserRepository userRepository;
    private LoadUser.Callback callback;
    private String userId;

    @Inject
    public LoadUserImpl(Executor executor,
                         UserRepository userRepository) {
        this.executor = executor;
        this.mainThreadExecutor = new MainThreadExecutor();
        this.userRepository = userRepository;
    }

    @Override
    public void run(){
        final User user = userRepository.getUser(userId);
        mainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                callback.onUserLoaded(user);
            }
        });

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void execute(LoadUser.Callback callback) {
        this.callback = callback;
        executor.execute(this);
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
