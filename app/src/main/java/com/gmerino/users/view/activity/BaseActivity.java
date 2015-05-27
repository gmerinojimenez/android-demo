package com.gmerino.users.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.gmerino.users.ActivityModule;
import com.gmerino.users.App;

import java.util.List;

import dagger.ObjectGraph;

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
}