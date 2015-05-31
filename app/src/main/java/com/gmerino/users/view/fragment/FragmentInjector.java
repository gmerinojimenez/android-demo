package com.gmerino.users.view.fragment;

import android.app.Fragment;

import com.gmerino.users.view.activity.BaseActivity;

/**
 * Created by Guille on 30/05/2015.
 */
public class FragmentInjector {

    private boolean injected = false;

    private Fragment fragment;

    public FragmentInjector(Fragment fragment){
        this.fragment = fragment;
    }

    public void attemptFragmentInjection(){
        if(!injected) {
            BaseActivity activity = (BaseActivity) fragment.getActivity();
            if(activity != null){
                activity.inject(fragment);
                injected = true;
            }
        }
    }
}
