package com.gmerino.users.presenter

import com.domain.user.data.User
import com.gmerino.users.interactor.DeleteUser
import com.gmerino.users.interactor.FilterUsers
import com.gmerino.users.interactor.LoadUsers
import com.gmerino.users.interactor.PersistUser
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

class UserListPresenterImpl(private val loadUsersInteractor: LoadUsers,
                            private val persistUserInteractor: PersistUser,
                            private val deleteUserInteractor: DeleteUser,
                            private val filterUsers: FilterUsers) : UserListPresenter {

    private var view: UserListView? = null

    private var progressView: ProgressView? = null

    override fun setView(view: UserListView) {
        this.view = view
    }

    override fun setProgressView(progressView: ProgressView) {
        this.progressView = progressView
    }

    override fun loadUsers() {
        progressView!!.showProgress()
        loadUsersInteractor.execute(object : LoadUsers.Callback {
            override fun onUsersLoaded(users: List<User>) {
                view!!.onUsersLoaded(users) //TODO WTF
                progressView!!.dismissProgress()
            }
        })
    }

    override fun setStarred(user: User, starred: Boolean) {
        progressView!!.showProgress()
        //        user.setStarred(starred);
        persistUserInteractor.persist(user, object : PersistUser.Callback {
            override fun onUserPersisted(user: User) {
                //Nothing to do now
                progressView!!.dismissProgress()
            }
        })
    }

    override fun deleteUser(user: User) {
        progressView!!.showProgress()
        deleteUserInteractor.delete(user, object : DeleteUser.Callback {
            override fun onUserDeleted(user: User) {
                view!!.refresh()
                progressView!!.dismissProgress()
            }
        })
    }

    override fun filterUsers(filter: String) {
        progressView!!.showProgress()
        filterUsers.filter(filter, object : FilterUsers.Callback {
            override fun onUsersFiltered(user: List<User>) {
                view!!.refresh()
                progressView!!.dismissProgress()
            }
        })
    }
}
