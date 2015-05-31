package com.gmerino.data.repository;

import com.domain.user.data.Location;
import com.domain.user.data.Name;
import com.domain.user.data.User;
import com.gmerino.data.net.RandomUserRestAPI;
import com.gmerino.data.net.Result;
import com.gmerino.data.net.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by Guille on 31/05/2015.
 */
public class RestUserRepository implements UserRepository {

    private static final Integer USERS_PER_REQUEST = 20;

    private void populate(int howMany) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(RandomUserRestAPI.SERVER_URL)
                .build();

        RandomUserRestAPI service = restAdapter.create(RandomUserRestAPI.class);

        service.getList(USERS_PER_REQUEST);

//        service.getList(howMany, new Callback<UserResponse>() {
//            @Override
//            public void success(UserResponse users, Response response) {
////                    userList = users;
//                fillStructures(users);
//            }
//
//            @Override
//            public void failure(RetrofitError retrofitError) {
//                Log.e(TAG, "Error reading from server");
//            }
//        });
    }

    @Override
    public List<User> getUsers() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(RandomUserRestAPI.SERVER_URL)
                .build();

        RandomUserRestAPI service = restAdapter.create(RandomUserRestAPI.class);

        UserResponse response = service.getList(USERS_PER_REQUEST);

        List<User> userList = new ArrayList<>(response.getResults().size());

        for(Result result: response.getResults()){
            User user = result.getUser();
            userList.add(user);
        }

        return userList;
    }

    @Override
    public User getUser(String userId) {
        return getFakeUser();
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
