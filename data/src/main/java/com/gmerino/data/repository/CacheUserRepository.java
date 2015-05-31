package com.gmerino.data.repository;

import com.domain.user.data.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Guille on 31/05/2015.
 */
public class CacheUserRepository implements UserRepository {

    private UserRepository lowerLevelRepository;

    private List<User> cachedUsers = new ArrayList<>();

    private Map<String, User> userMap = new HashMap<>();

    public CacheUserRepository(UserRepository lowerLevelRepository){
        this.lowerLevelRepository = lowerLevelRepository;
    }

    private boolean isInitialized(){
        return cachedUsers.size() > 0;
    }

    @Override
    public List<User> getUsers() {
        List<User> result;
        if(isInitialized()){
            result = cachedUsers;
        } else {
            result = lowerLevelRepository.getUsers();
            updateMap();
        }
        return result;
    }

    private void updateMap() {
        userMap.clear();
        for(User user : cachedUsers){
            userMap.put(user.getMd5(), user);
        }
    }

    @Override
    public User getUser(String userId) {
        User result;
        result = userMap.get(userId);
        if(result == null){
            result = lowerLevelRepository.getUser(userId);
        }
        return result;
    }
}
