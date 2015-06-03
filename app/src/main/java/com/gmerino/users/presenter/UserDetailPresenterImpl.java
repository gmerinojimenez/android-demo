package com.gmerino.users.presenter;

import com.domain.user.data.User;
import com.gmerino.users.interactor.LoadUser;
import com.gmerino.users.view.fragment.UserDetailView;

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
 * Created by Guille on 31/05/2015.
 */
public class UserDetailPresenterImpl implements UserDetailPresenter {

    private UserDetailView view;

    private LoadUser loadUserInteractor;

    public UserDetailPresenterImpl(LoadUser loadUser){
        this.loadUserInteractor = loadUser;
    }

    @Override
    public void loadUser(String id) {
        loadUserInteractor.setUserId(id);
        loadUserInteractor.execute(new LoadUser.Callback() {
            @Override
            public void onUserLoaded(User user) {
                view.onUserLoaded(user);
            }
        });
    }

    @Override
    public void setView(UserDetailView view) {
        this.view = view;
    }
}
