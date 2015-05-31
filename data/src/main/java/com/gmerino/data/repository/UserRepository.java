package com.gmerino.data.repository;

import com.domain.user.data.User;

import java.util.List;

/**
 * Created by Guille on 31/05/2015.
 */
public interface UserRepository {

    List<User> getUsers();

    User getUser(final String userId);
}
