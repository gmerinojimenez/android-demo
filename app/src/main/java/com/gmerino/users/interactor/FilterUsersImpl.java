package com.gmerino.users.interactor;

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

import com.gmerino.commons.Executor;
import com.gmerino.commons.Interactor;
import com.gmerino.commons.MainThreadExecutor;
import com.gmerino.data.repository.UserRepository;
import com.gmerino.users.data.FilterableRepository;

import javax.inject.Inject;


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
public class FilterUsersImpl implements FilterUsers, Interactor {

    private final Executor executor;
    private final MainThreadExecutor mainThreadExecutor;
    private final FilterableRepository filterableRepository;
    private final UserRepository userRepository;
    private Callback callback;

    private String filter;

    @Inject
    public FilterUsersImpl(Executor executor,
                           UserRepository userRepository,
                           FilterableRepository filterableRepository,
                           MainThreadExecutor mainThreadExecutor) {
        this.executor = executor;
        this.mainThreadExecutor = mainThreadExecutor;
        this.filterableRepository = filterableRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run() {
        filterableRepository.applyFilter(filter);
        mainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                callback.onUsersFiltered(userRepository.getUsers());
            }
        });
    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void filter(String filter, Callback callback) {
        this.callback = callback;
        this.filter = filter;
        executor.execute(this);

    }
}
