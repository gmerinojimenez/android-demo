package com.gmerino.users.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.gmerino.users.R;
import com.gmerino.users.fragment.UserListFragment;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    private UserListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
