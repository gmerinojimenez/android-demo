package com.gmerino.users.presenter

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

interface UserDetailPresenter {

    fun loadUser(id: String)

    fun setView(view: UserDetailView)

    fun setProgressView(view: ProgressView)
}