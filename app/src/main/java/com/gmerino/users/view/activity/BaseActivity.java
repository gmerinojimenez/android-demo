package com.gmerino.users.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.gmerino.users.ActivityModule;
import com.gmerino.users.App;

import java.util.List;

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
 * Created by Guille on 27/05/2015.
 */
public abstract class BaseActivity extends Activity{

    private ObjectGraph objectGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App app = (App) getApplication();
        List<Object> modules = getModules();
        modules.add(new ActivityModule(this));
        objectGraph = app.plus(modules);
        objectGraph.inject(this);

    }

    protected abstract List<Object> getModules();

    public void inject(Fragment fragment){
        objectGraph.inject(fragment);
    }
}