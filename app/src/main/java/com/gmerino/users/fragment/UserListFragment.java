package com.gmerino.users.fragment;

import android.app.Fragment;

import com.domain.user.data.User;
import com.gmerino.users.presenter.UserListPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Guille on 15/05/2015.
 */
public class UserListFragment extends Fragment implements UserListView{

    @Inject
    UserListPresenter presenter;

    @Override
    public void loadList(List<User> user) {

    }
}
