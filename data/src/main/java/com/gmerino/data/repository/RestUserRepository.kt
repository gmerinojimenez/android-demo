package com.gmerino.data.repository

import android.util.Log
import com.domain.user.data.Location
import com.domain.user.data.Name
import com.domain.user.data.User
import com.gmerino.data.net.RandomUserRestAPI
import java.util.*

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
class RestUserRepository(private val randomUserRestAPI: RandomUserRestAPI) : UserRepository {

    override fun getUsers(): List<User> {
        val userList = ArrayList<User>()
        try {

            val response = randomUserRestAPI.getList(USERS_PER_REQUEST)

            for (user in response.users) {
                //                User user = result.getUser();
                userList.add(user)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error", e)
        }

        return userList

    }

    override fun getUser(userId: String): User {
        return fakeUser
    }

    override fun persist(user: User) {
        //Nothing to do
    }

    override fun delete(user: User) {
        //Nothing to do
    }

    private val fakeUser: User
        get() {
            val user = User()
            val name = Name()
            name.first = "User"
            name.last = "Not Found"
            name.title = ""
            user.name = name
            val location = Location()
            location.city = "Madrid"
            location.state = "Madrid"
            location.street = "Gran Via"
            user.location = location
            return user
        }

    companion object {

        private val USERS_PER_REQUEST = 20
        private val TAG = RestUserRepository::class.java.canonicalName
    }
}
