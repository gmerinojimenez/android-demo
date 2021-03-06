package com.gmerino.users.interactor;

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
import com.gmerino.users.FakeExecutor;
import com.gmerino.users.FakeMainThreadExecutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Guille on 12/06/2015.
 */
public class LoadUserTest {

    private static final String ANY_USER_ID = "1";
    LoadUserImpl loadUser;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        loadUser = new LoadUserImpl(new FakeExecutor(),
                userRepository, new FakeMainThreadExecutor());

        when(userRepository.getUser(ANY_USER_ID)).thenReturn(user);
        when(user.getMd5()).thenReturn(ANY_USER_ID);
    }


    @Test
    public void shouldRetrieveAnUser() {
        givenAnUserId();
        LoadUser.Callback callback = mock(LoadUser.Callback.class);

        loadUser.execute(callback);

        verify(callback).onUserLoaded(isA(User.class));
    }

    private void givenAnUserId() {
        loadUser.setUserId(ANY_USER_ID);
    }
}