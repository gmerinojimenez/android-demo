package com.gmerino.users.presenter

import com.domain.user.data.Location
import com.domain.user.data.Name
import com.domain.user.data.User
import com.gmerino.users.view.ProgressView
import com.gmerino.users.view.fragment.UserDetailView

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
 * Created by Guille on 31/05/2015.
 */
class UserDetailPresenterMock : UserDetailPresenter {

    private var view: UserDetailView? = null
    private var progressView: ProgressView? = null

    override fun loadUser(id: String) {
        val user = User()
        val name = Name()
        name.first = "Luke"
        name.last = "Skywalker"
        name.title = "Mr"
        user.name = name
        val location = Location()
        location.city = "Madrid"
        location.state = "Madrid"
        location.street = "Gran Via"
        user.location = location

        view!!.onUserLoaded(user)
    }

    override fun setView(view: UserDetailView) {
        this.view = view
    }

    override fun setProgressView(progressView: ProgressView) {
        this.progressView = progressView
    }
}
