package com.gmerino.users.interactor

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

import com.gmerino.commons.Executor
import com.gmerino.commons.Interactor
import com.gmerino.commons.MainThreadExecutor
import com.gmerino.data.repository.UserRepository
import javax.inject.Inject


/**
 * Created by Guille on 31/05/2015.
 */
class LoadUsersImpl
@Inject
constructor(private val executor: Executor,
            private val userRepository: UserRepository, mainThreadExecutor: com.gmerino.commons.MainThreadExecutor) : Interactor, LoadUsers {
    private val mainThreadExecutor: MainThreadExecutor
    private var callback: LoadUsers.Callback? = null

    init {
        this.mainThreadExecutor = mainThreadExecutor
    }

    override fun run() {
        val users = userRepository.getUsers()
        mainThreadExecutor.execute { callback!!.onUsersLoaded(users) }

    }

    override fun onFailure(t: Throwable) {

    }

    override fun execute(callback: LoadUsers.Callback) {
        this.callback = callback
        executor.execute(this)
    }
}
