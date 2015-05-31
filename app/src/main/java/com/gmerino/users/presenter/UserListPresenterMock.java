package com.gmerino.users.presenter;

import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.users.view.fragment.UserListView;

import java.util.ArrayList;
import java.util.List;

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
    public void onUserClicked(User user) {

    }

    @Override
    public void loadUsers() {
        view.onUsersLoaded(users);
    }
}
