package com.gmerino.users.presenter;

import com.domain.user.data.Location;
import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.users.view.fragment.UserDetailView;

/**
 * Created by Guille on 31/05/2015.
 */
public class UserDetailPresenterMock implements UserDetailPresenter {

    private UserDetailView view;

    @Override
    public void loadUser(String id) {
        User user = new User();
        Name name = new Name();
        name.setFirst("Luke");
        name.setLast("Skywalker");
        name.setTitle("Mr");
        user.setName(name);
        Location location = new Location();
        location.setCity("Madrid");
        location.setState("Madrid");
        location.setStreet("Gran Via");
        user.setLocation(location);

        view.onUserLoaded(user);
    }

    @Override
    public void setView(UserDetailView view) {
        this.view = view;
    }
}
