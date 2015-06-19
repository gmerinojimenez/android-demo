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


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

import com.gmerino.data.repository.UserRepository;
import com.gmerino.users.FakeExecutor;

/**
 * Created by Guille on 12/06/2015.
 */
public class LoadUserTest {

	LoadUserImpl loadUser;

	@Mock
	UserRepository userRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		loadUser = new LoadUserImpl(new FakeExecutor(), userRepository);
	}

//	@Test
//	public void shouldDelegateExecutionToExecutor() throws CannotUpdateContactRelationshipException {
//		givenAnAddContactInteractor();
//
//		whenExecuted();
//
//		verifyUserRepositoryUpgradeFromUnknown();
//	}
//
//	private void givenAnAddContactInteractor() {
//		interactor = new AddContactInteractor(new FakeExecutor(), userRepository);
//	}
//
//	private void whenExecuted() {
//		interactor.execute(SOME_USER_ID);
//	}
//
//	private void verifyUserRepositoryUpgradeFromUnknown() throws CannotUpdateContactRelationshipException {
//		verify(userRepository).addContacts(SOME_USER_IDS);
//	}

}