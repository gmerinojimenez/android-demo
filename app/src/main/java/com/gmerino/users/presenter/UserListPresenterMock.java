package com.gmerino.users.presenter;

import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.users.view.fragment.UserListView;

import java.util.ArrayList;
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

/**
 * Created by Guille on 30/05/2015.
 */
public class UserListPresenterMock implements UserListPresenter {

    private List<User> users = new ArrayList<>();

    private UserListView view;

    public UserListPresenterMock() {
        User user = new User();
        Name name = new Name();
        name.setFirst("Luke");
        name.setLast("Skywalker");
        name.setTitle("Mr");
        user.setName(name);
        users.add(user);

        user = new User();
        name = new Name();
        name.setFirst("Leia");
        name.setLast("Skywalker");
        name.setTitle("Ms");
        user.setName(name);
        users.add(user);

        user = new User();
        name = new Name();
        name.setFirst("Han");
        name.setLast("Solo");
        name.setTitle("Mr");
        user.setName(name);
        users.add(user);

        user = new User();
        name = new Name();
        name.setFirst("Darth");
        name.setLast("Vader");
        name.setTitle("Mr");
        user.setName(name);
        users.add(user);
    }

    @Override
    public void setView(UserListView view) {
        this.view = view;
    }

    @Override
    public void loadUsers() {
        view.onUsersLoaded(users);
    }
}
