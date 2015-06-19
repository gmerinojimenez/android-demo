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

import com.domain.user.data.User;
import com.gmerino.users.interactor.LoadUser;
import com.gmerino.users.view.ProgressView;
import com.gmerino.users.view.fragment.UserDetailView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

/**
 * Created by Guille on 20/06/2015.
 */
public class UserDetailPresenterTest {

    private static final String ANY_USER_ID = "1";

    @Mock
    UserDetailView view;

    @Mock
    ProgressView progressView;

    LoadUser loadUser = new FakeLoadUser();

    UserDetailPresenterImpl userDetailPresenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        userDetailPresenter = new UserDetailPresenterImpl(loadUser);
        userDetailPresenter.setProgressView(progressView);
        userDetailPresenter.setView(view);
    }

    @Test
    public void testUserLoadedCallbackIsCalled(){

        userDetailPresenter.loadUser(ANY_USER_ID);

        verify(view).onUserLoaded(isA(User.class));
    }


    class FakeLoadUser implements LoadUser {

        private User user;

        @Override
        public void execute(Callback callback) {
            callback.onUserLoaded(user);
        }

        @Override
        public void setUserId(String userId) {
            user = new User();
        }
    }




}
