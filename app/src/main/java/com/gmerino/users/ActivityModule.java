package com.gmerino.users;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(library = true, complete = false)
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("ActivityContext")
    Context provideApplicationContext() {
        return context;
    }
}
