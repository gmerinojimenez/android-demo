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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Guille on 20/06/2015.
 */
public class PersistUserTest {

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    private PersistUser persistUser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        persistUser = new PersistUserImpl(new FakeExecutor(),
                userRepository, new FakeMainThreadExecutor());
    }

    @Test
    public void testUserIsPersisted(){
        PersistUser.Callback callback = mock(PersistUser.Callback.class);

        persistUser.persist(user, callback);

        verify(userRepository).persist(user);
    }

}
