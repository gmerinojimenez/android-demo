package com.gmerino.users.core

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

import com.gmerino.commons.MainThreadExecutor

import javax.inject.Inject

/**
 * Created by Guille on 20/06/2015.
 */
class MainThreadExecutorImpl
@Inject
constructor(private val retrofitMainThreadExecutor: retrofit.android.MainThreadExecutor) : MainThreadExecutor {

    override fun execute(runnable: Runnable) {
        retrofitMainThreadExecutor.execute(runnable)
    }

}
