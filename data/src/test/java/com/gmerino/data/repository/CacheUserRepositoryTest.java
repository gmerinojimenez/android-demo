package com.gmerino.data.repository;

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

import com.domain.user.data.Name;
import com.domain.user.data.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
 * Created by Guille on 12/06/2015.
 */
public class CacheUserRepositoryTest {

    private static final int ANY_LIMIT = 20;
    private static final String ANY_TITLE = "Mr";
    private static final String ANY_FIRST_NAME = "John";
    private static final String ANY_LAST_NAME = "Doe";

    @Mock
    UserRepository userRepository;

    CacheUserRepository cacheUserRepository;
    List<User> expectedResponse;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        cacheUserRepository = new CacheUserRepository(userRepository);
        setupGoodResponse();
    }


    @Test
    public void testGetUsersRetrieveAList(){
        givenAWorkingRestApi();
        List<User> response = cacheUserRepository.getUsers();
        thenResultIsValid(response);
    }

    private void thenResultIsValid(List<User> responseList) {
        assertEquals(responseList.size(), ANY_LIMIT);
        for(User user : responseList){
            assertEquals(user.getName().getFirst(), ANY_FIRST_NAME);
            assertEquals(user.getName().getLast(), ANY_LAST_NAME);
            assertEquals(user.getName().getTitle(), ANY_TITLE);
        }
    }

    private void setupGoodResponse() {
        expectedResponse = new ArrayList<>(ANY_LIMIT);

        for(int i = 0; i < ANY_LIMIT; i++){
            Name name = new Name();
            name.setFirst(ANY_FIRST_NAME+i);
            name.setLast(ANY_LAST_NAME+i);
            name.setTitle(ANY_TITLE);

            User user = new User();
            user.setName(name);

            expectedResponse.add(user);
        }
    }

    private void givenAWorkingRestApi() {
        when(userRepository.getUsers()).thenReturn(expectedResponse);
    }

}
