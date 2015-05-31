package com.gmerino.users.presenter;

import com.domain.user.data.User;
import com.gmerino.users.view.fragment.UserListView;


/**
 * Created by Guille on 30/05/2015.
 */
public interface UserListPresenter {

    void setView(UserListView view);

    void loadUsers();
}
