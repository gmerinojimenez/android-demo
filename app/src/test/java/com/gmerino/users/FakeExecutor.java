package com.gmerino.users;

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

import javax.inject.Inject;

import com.gmerino.commons.Executor;
import com.gmerino.commons.Interactor;

public class FakeExecutor implements Executor{

	public boolean runInteractors = true;

	@Inject
	public FakeExecutor() {
	}

	@Override
	public void execute(Interactor interactor) {
		if (runInteractors) {
			try {
				interactor.run();
			} catch (Throwable throwable) {

			}
		}
	}

	@Override
	public void reset() {
		// Nothing to do
	}
}
