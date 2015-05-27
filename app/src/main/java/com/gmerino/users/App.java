package com.gmerino.users;

import android.app.Application;

import com.gmerino.users.module.RootModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

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