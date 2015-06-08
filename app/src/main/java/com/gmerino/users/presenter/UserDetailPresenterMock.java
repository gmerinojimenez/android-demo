package com.gmerino.users.presenter;

import com.domain.user.data.Location;
import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.users.view.ProgressView;
import com.gmerino.users.view.fragment.UserDetailView;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Created by Guille on 31/05/2015.
 */
public class UserDetailPresenterMock implements UserDetailPresenter {

    private UserDetailView view;
    private ProgressView progressView;

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

    @Override
    public void setProgressView(ProgressView progressView) {
        this.progressView = progressView;
    }
}
