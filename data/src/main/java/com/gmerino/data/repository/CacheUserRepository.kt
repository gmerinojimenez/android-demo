package com.gmerino.data.repository

import com.domain.user.data.User
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
class CacheUserRepository(private val lowerLevelRepository: UserRepository) : UserRepository {

    private var cachedUsers: MutableList<User> = ArrayList()

    private val userMap = HashMap<String, User>()

    private val isInitialized: Boolean
        get() = cachedUsers.size > 0

    override fun getUsers(): List<User> {
        if (!isInitialized) {
            cachedUsers = lowerLevelRepository.getUsers().toMutableList()
            updateMap()
        }
        return cachedUsers
    }

    private fun updateMap() {
        userMap.clear()
        for (user in cachedUsers) {
            userMap.put(user.id.value, user)
        }
    }

    override fun getUser(userId: String): User {
        var result: User?
        result = userMap[userId]
        if (result == null) {
            result = lowerLevelRepository.getUser(userId)
        }
        return result!!
    }

    override fun persist(user: User) {
        lowerLevelRepository.persist(user)
    }

    override fun delete(user: User) {
        userMap.remove(user.id.value)
        cachedUsers.remove(user)
    }
}
