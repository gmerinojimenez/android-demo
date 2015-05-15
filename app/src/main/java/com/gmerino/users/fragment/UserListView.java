package com.gmerino.users.fragment;

import com.domain.user.data.User;

import java.util.List;

/**
 * Created by Guille on 15/05/2015.
 */
public interface UserListView {

    void loadList(List<User> user);
}
