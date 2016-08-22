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
 * Created by Guille on 04/06/2015.
 */
class LoadUserImpl
@Inject
constructor(private val executor: Executor,
            private val userRepository: UserRepository, private val mainThreadExecutor: MainThreadExecutor) : Interactor, LoadUser {
    private var callback: LoadUser.Callback? = null
    private var userId: String? = null

    override fun run() {
        val user = userRepository.getUser(userId!!)
        mainThreadExecutor.execute { callback!!.onUserLoaded(user) }

    }

    override fun onFailure(t: Throwable) {

    }

    override fun execute(callback: LoadUser.Callback) {
        this.callback = callback
        executor.execute(this)
    }

    override fun setUserId(userId: String) {
        this.userId = userId
    }

}
