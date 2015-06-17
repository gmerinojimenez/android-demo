package com.gmerino.users.data;

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

import com.domain.user.data.User;
import com.gmerino.data.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Guille on 11/06/2015.
 */
public class UserFilteredRepository implements UserRepository, FilterableRepository {

    private UserRepository lowerLevelRepository;

    private List<User> users = new ArrayList<>();
    private Map<String, User> userMap = new HashMap<>();
    private static User.UserComparator comparator;

    private boolean initialized = false;

    public UserFilteredRepository(UserRepository lowerLevelRepository,
                                  User.UserComparator userComparator){
        this.lowerLevelRepository = lowerLevelRepository;
        this.comparator = userComparator;
    }

    @Override
    public List<User> getUsers() {
        if(!initialized){
            users = lowerLevelRepository.getUsers();
            updateMap();
        }
        return users;
    }

    private void updateMap() {
        userMap.clear();
        for(User user : users){
            userMap.put(user.getMd5(), user);
        }
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    @Override
    public void persist(User user) {
        lowerLevelRepository.persist(user);
    }

    @Override
    public void applyFilter(String filter) {
        getUsers();
        userMap.clear();
        List<User> provisionalUsers =  new ArrayList<>(users);

        users.clear();
        for(User user : provisionalUsers){
            if(passTheFilter(filter, user)){
                users.add(user);
                userMap.put(user.getMd5(), user);
            }
        }

        Collections.sort(users, comparator);
    }

    private boolean passTheFilter(String filter, User user){
        return filter != null && !filter.isEmpty() && user.getName().toString().toLowerCase().contains(filter.toLowerCase());
    }
}
