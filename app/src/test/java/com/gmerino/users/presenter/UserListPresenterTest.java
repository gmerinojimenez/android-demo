package com.gmerino.users.presenter;

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
import com.gmerino.users.interactor.DeleteUser;
import com.gmerino.users.interactor.FilterUsers;
import com.gmerino.users.interactor.LoadUsers;
import com.gmerino.users.interactor.PersistUser;
import com.gmerino.users.view.ProgressView;
import com.gmerino.users.view.fragment.UserListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Guille on 20/06/2015.
 */
public class UserListPresenterTest {

    private static final int ANY_LIMIT = 20;
    private static final String ANY_TITLE = "Mr";
    private static final String ANY_FIRST_NAME = "John";
    private static final String ANY_LAST_NAME = "Doe";
    private static final boolean ANY_BOOLEAN = true;

    @Mock
    UserListView view;
    @Mock
    ProgressView progressView;

    @Mock
    PersistUser persistUserInteractor;

    @Mock
    DeleteUser deleteUserInteractor;

    @Mock
    FilterUsers filterUsers;

    LoadUsers loadUsersInteractor;

    List<User> expectedResponse;


    UserListPresenterImpl userListPresenter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        setupExpectedResponse();
        loadUsersInteractor = new FakeLoadUsersInteractor();
        userListPresenter = new UserListPresenterImpl(loadUsersInteractor,
                persistUserInteractor, deleteUserInteractor, filterUsers);
        userListPresenter.setProgressView(progressView);
        userListPresenter.setView(view);
    }

    @Test
    public void testLoadUsers() {
        userListPresenter.loadUsers();

        verify(view).onUsersLoaded(expectedResponse);
    }

    @Test
    public void testStarredUser() {
        userListPresenter.setStarred(mock(User.class), ANY_BOOLEAN);

        verify(persistUserInteractor).persist(isA(User.class), isA(PersistUser.Callback.class));
    }

    @Test
    public void testDeletedExistingUser() {
        userListPresenter.deleteUser(isA(User.class));

        verify(deleteUserInteractor).delete(isA(User.class), isA(DeleteUser.Callback.class));
    }

    private void setupExpectedResponse() {
        expectedResponse = new ArrayList<>(ANY_LIMIT);

        for (int i = 0; i < ANY_LIMIT; i++) {
            Name name = new Name();
            name.setFirst(ANY_FIRST_NAME + i);
            name.setLast(ANY_LAST_NAME + i);
            name.setTitle(ANY_TITLE);

            User user = new User();
            user.setName(name);

            expectedResponse.add(user);
        }
    }

    class FakeLoadUsersInteractor implements LoadUsers {

        @Override
        public void execute(Callback callback) {
            callback.onUsersLoaded(expectedResponse);
        }
    }
}
