package com.gmerino.users.view;

import com.domain.user.data.User;

import java.util.List;

/**
 *
 */
public interface UserList {

    void loadList(List<User> users);
}