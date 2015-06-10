package com.gmerino.users.presenter;

import com.domain.user.data.User;
import com.gmerino.users.interactor.LoadUsers;
import com.gmerino.users.interactor.PersistUser;
import com.gmerino.users.view.ProgressView;
import com.gmerino.users.view.fragment.UserListView;

import java.util.List;


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

public class UserListPresenterImpl implements UserListPresenter {

    private UserListView view;

    private ProgressView progressView;

    private LoadUsers loadUsersInteractor;
    private PersistUser persistUserInteractor;

    public UserListPresenterImpl(LoadUsers loadUsers,
                                 PersistUser persistUser) {
        this.loadUsersInteractor = loadUsers;
        this.persistUserInteractor = persistUser;
    }

    @Override
    public void setView(UserListView view) {
        this.view = view;
    }

    @Override
    public void setProgressView(ProgressView progressView) {
        this.progressView = progressView;
    }

    @Override
    public void loadUsers() {
        progressView.showProgress();
        loadUsersInteractor.execute(new LoadUsers.Callback() {
            @Override
            public void onUsersLoaded(List<User> users) {
                view.onUsersLoaded(users);
                progressView.dismissProgress();
            }
        });
    }

    @Override
    public void setStarred(User currentUser, boolean starred) {
        progressView.showProgress();
        currentUser.setStarred(starred);
        persistUserInteractor.persist(currentUser, new PersistUser.Callback() {
                    @Override
                    public void onUserPersisted(User user) {
                        //Nothing to do now
                        progressView.dismissProgress();
                    }
                }

        );
    }
}
