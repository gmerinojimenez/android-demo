package com.gmerino.users.presenter;

import com.gmerino.data.repository.UserRepository;
import com.gmerino.users.view.fragment.UserListView;

import javax.inject.Inject;


/**
 * Created by Guille on 15/05/2015.
 */
public class UserListPresenterImpl implements UserListPresenter {

    private UserListView view;

    private UserRepository userRepository;

    public UserListPresenterImpl(UserRepository userRepository){
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
