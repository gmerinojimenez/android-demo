package com.gmerino.users.presenter;

import com.gmerino.data.repository.UserRepository;
import com.gmerino.users.interactor.LoadUsersInteractor;
import com.gmerino.users.view.fragment.UserListView;


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

    private UserRepository userRepository;

    private LoadUsersInteractor loadUsersInteractor;

    public UserListPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void setView(UserListView view) {
        this.view = view;
    }

    @Override
    public void loadUsers() {
        userRepository.getUsers();
    }
}
