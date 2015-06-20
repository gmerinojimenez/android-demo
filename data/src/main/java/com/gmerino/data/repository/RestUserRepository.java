package com.gmerino.data.repository;

import android.util.Log;

import com.domain.user.data.Location;
import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.data.net.RandomUserRestAPI;
import com.gmerino.data.net.Result;
import com.gmerino.data.net.UserResponse;

import java.util.ArrayList;
import java.util.List;

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
public class RestUserRepository implements UserRepository {

    private static final Integer USERS_PER_REQUEST = 20;
    private static final String TAG = RestUserRepository.class.getCanonicalName();

    private final RandomUserRestAPI randomUserRestAPI;

    public RestUserRepository(RandomUserRestAPI randomUserRestAPI){
        this.randomUserRestAPI = randomUserRestAPI;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try {

            UserResponse response = randomUserRestAPI.getList(USERS_PER_REQUEST);

            for (Result result : response.getResults()) {
                User user = result.getUser();
                userList.add(user);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }
        return userList;

    }

    @Override
    public User getUser(String userId) {
        return getFakeUser();
    }

    @Override
    public void persist(User user) {
        //Nothing to do
    }

    @Override
    public void delete(User user) {
        //Nothing to do
    }

    private User getFakeUser() {
        User user = new User();
        Name name = new Name();
        name.setFirst("User");
        name.setLast("Not Found");
        name.setTitle("");
        user.setName(name);
        Location location = new Location();
        location.setCity("Madrid");
        location.setState("Madrid");
        location.setStreet("Gran Via");
        user.setLocation(location);
        return user;
    }
}
