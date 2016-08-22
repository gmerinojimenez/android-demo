package com.gmerino.users.presenter

import java.util.ArrayList

import com.domain.user.data.Name
import com.domain.user.data.User
import com.gmerino.users.view.ProgressView
import com.gmerino.users.view.fragment.UserListView

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
 * Created by Guille on 30/05/2015.
 */
class UserListPresenterMock : UserListPresenter {

    private val users = ArrayList<User>()

    private var view: UserListView? = null

    private var progressView: ProgressView? = null

    init {
        var user = User()
        var name = Name()
        name.first = "Luke"
        name.last = "Skywalker"
        name.title = "Mr"
        user.name = name
        users.add(user)

        user = User()
        name = Name()
        name.first = "Leia"
        name.last = "Skywalker"
        name.title = "Ms"
        user.name = name
        users.add(user)

        user = User()
        name = Name()
        name.first = "Han"
        name.last = "Solo"
        name.title = "Mr"
        user.name = name
        users.add(user)

        user = User()
        name = Name()
        name.first = "Darth"
        name.last = "Vader"
        name.title = "Mr"
        user.name = name
        users.add(user)
    }

    override fun setView(view: UserListView) {
        this.view = view
    }

    override fun setProgressView(progressView: ProgressView) {
        this.progressView = progressView
    }

    override fun loadUsers() {
        view!!.onUsersLoaded(users)
    }

    override fun setStarred(currentUser: User, isChecked: Boolean) {
        //        currentUser.setStarred(isChecked);
    }

    override fun deleteUser(currentUser: User) {

    }

    override fun filterUsers(filter: String) {

    }
}
