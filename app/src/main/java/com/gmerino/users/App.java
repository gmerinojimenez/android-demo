package com.gmerino.users;

import android.app.Application;

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
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

}