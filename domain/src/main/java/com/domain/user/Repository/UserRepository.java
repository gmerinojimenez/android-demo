package com.domain.user.Repository;

import com.domain.user.data.User;

import java.util.List;

/**
 * Created by Guille on 15/05/2015.
 */
public interface UserRepository {

    List<User> getUsers();

}
