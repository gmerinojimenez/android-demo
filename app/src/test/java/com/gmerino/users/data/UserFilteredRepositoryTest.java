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

import com.domain.user.data.Name;
import com.domain.user.data.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Guille on 12/06/2015.
 */
public class UserFilteredRepositoryTest {

    private static final int ANY_LIMIT = 20;
    private static final String ANY_TITLE = "Mr";
    private static final String ANY_FIRST_NAME = "John";
    private static final String ANY_LAST_NAME = "Doe";

    private static final String SIMPLE_FILTER = ANY_FIRST_NAME;
    private static final String NUMERIC_FILTER = "1";
    private static final String STRICT_FILTER = SIMPLE_FILTER+NUMERIC_FILTER;
    private static final int NUMERIC_FILTER_SIZE = 11;
    private static final int STRICT_FILTER_SIZE = 11;



    @Mock
    UserFilteredRepository lowerLevelRepository;

    User.UserComparator comparator = new User.UserComparator();

    UserFilteredRepository filteredRepository;
    List<User> expectedResponse;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        filteredRepository = new UserFilteredRepository(lowerLevelRepository, comparator);
        setupGoodResponse();
    }


    @Test
    public void testGetUsersWithoutFilterRetrievesAList(){
        givenAWorkingRestApi();
        List<User> response = filteredRepository.getUsers();
        thenResultIsValid(response);
    }

    @Test
    public void testGetUsersWithSimpleFilterRetrievesAList(){
        givenAWorkingRestApi();
        filteredRepository.applyFilter(SIMPLE_FILTER);
        List<User> response = filteredRepository.getUsers();
        thenResultIsValidForSingleFilter(response);
    }

    @Test
    public void testGetUsersWithNumericFilterRetrievesAList(){
        givenAWorkingRestApi();
        filteredRepository.applyFilter(NUMERIC_FILTER);
        List<User> response = filteredRepository.getUsers();
        thenResultIsValidForNumericFilter(response);
    }

    @Test
    public void testGetUsersWithStrictFilterRetrievesAList(){
        givenAWorkingRestApi();
        filteredRepository.applyFilter(STRICT_FILTER);
        List<User> response = filteredRepository.getUsers();
        thenResultIsValidForStrictFilter(response);
    }

    private void thenResultIsValid(List<User> responseList) {
        assertEquals(responseList.size(), ANY_LIMIT);
        for(User user : responseList){
            assertTrue(user.getName().getFirst().contains(ANY_FIRST_NAME));
            assertTrue(user.getName().getLast().contains(ANY_LAST_NAME));
            assertTrue(user.getName().getTitle().contains(ANY_TITLE));
        }
    }

    private void thenResultIsValidForSingleFilter(List<User> responseList) {
        assertEquals(responseList.size(), ANY_LIMIT);
    }

    private void thenResultIsValidForNumericFilter(List<User> responseList) {
        assertEquals(responseList.size(), NUMERIC_FILTER_SIZE);
    }

    private void thenResultIsValidForStrictFilter(List<User> responseList) {
        assertEquals(responseList.size(), STRICT_FILTER_SIZE);
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
        when(lowerLevelRepository.getUsers()).thenReturn(expectedResponse);
    }

}
