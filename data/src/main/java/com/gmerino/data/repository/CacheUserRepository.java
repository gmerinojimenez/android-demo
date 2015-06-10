package com.gmerino.data.repository;

import com.domain.user.data.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(!isInitialized()){
            cachedUsers = lowerLevelRepository.getUsers();
            updateMap();
        }
        return cachedUsers;
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

    @Override
    public void persist(User user) {
        //Nothing to do
    }
}
