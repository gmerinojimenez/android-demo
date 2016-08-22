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
import com.gmerino.users.data.FilterableRepository

import javax.inject.Inject


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
 * Created by Guille on 10/06/2015.
 */
class FilterUsersImpl
@Inject
constructor(private val executor: Executor,
            private val userRepository: UserRepository,
            private val filterableRepository: FilterableRepository,
            private val mainThreadExecutor: MainThreadExecutor) : FilterUsers, Interactor {
    private var callback: FilterUsers.Callback? = null

    private var filter: String? = null

    override fun run() {
        filterableRepository.applyFilter(filter!!)
        mainThreadExecutor.execute { callback!!.onUsersFiltered(userRepository.getUsers()) }
    }

    override fun onFailure(t: Throwable) {

    }

    override fun filter(filter: String, callback: FilterUsers.Callback) {
        this.callback = callback
        this.filter = filter
        executor.execute(this)

    }
}
