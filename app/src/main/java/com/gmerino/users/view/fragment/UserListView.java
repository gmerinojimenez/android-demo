package com.gmerino.users.view.fragment;

import com.domain.user.data.User;

import java.util.List;

/**
 * Created by Guille on 30/05/2015.
 */
public interface UserListView {

    void onUsersLoaded(List<User> users);
}
