package com.gmerino.users.data

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

import com.domain.user.data.User
import com.gmerino.data.repository.UserRepository
import java.util.*

/**
 * Created by Guille on 11/06/2015.
 */
class UserFilteredRepository(private val lowerLevelRepository: UserRepository,
                             userComparator: User.UserComparator) : UserRepository, FilterableRepository {

    private var users: MutableList<User> = ArrayList()
    private val userMap = HashMap<String, User>()

    private var initialized = false

    override fun getUsers(): List<User> {
        if (!initialized) {
            users = lowerLevelRepository.getUsers().toMutableList()
            updateMap()
            initialized = true
        }
        return users
    }

    private fun updateMap() {
        userMap.clear()
        for (user in users) {
            userMap.put(user.id.value, user)
        }
    }

    override fun getUser(userId: String): User {
        return userMap[userId]!!
    }

    override fun persist(user: User) {
        lowerLevelRepository.persist(user)
    }

    override fun delete(user: User) {
        users.remove(user)
        userMap.remove(user.id.value)
    }

    override fun applyFilter(filter: String) {
        initialized = false
        getUsers()
        userMap.clear()
        val provisionalUsers = ArrayList<User>()

        for (user in users) {
            if (passTheFilter(filter, user)) {
                provisionalUsers.add(user)
                userMap.put(user.id.value, user)
            }
        }

        users = provisionalUsers

        Collections.sort(users, comparator)
    }

    private fun passTheFilter(filter: String?, user: User): Boolean {
        return filter == null || filter.isEmpty() || user.name.toString().toLowerCase().contains(filter.toLowerCase())
    }

    companion object {
        private val comparator: User.UserComparator = User.UserComparator()
    }
}
