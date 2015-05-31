package com.gmerino.users.presenter;

import com.gmerino.users.view.fragment.UserDetailView;

public interface UserDetailPresenter {

    void loadUser(String id);

    void setView(UserDetailView view);
}
