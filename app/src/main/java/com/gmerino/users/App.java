package com.gmerino.users;

import android.app.Application;

import com.gmerino.users.module.RootModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

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
 * Created by Guille on 15/05/2015.
 */
public class App extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules());
        objectGraph.inject(this);
        objectGraph.injectStatics();

    }

    public Object[] getModules() {
        return new Object[]{
                new RootModule(this)
        };
    }

    public ObjectGraph plus(List<Object> modules){
        return objectGraph.plus(modules.toArray());
    }
}