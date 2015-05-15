package com.gmerino.commons;

/**
 * Created by Guille on 15/05/2015.
 */
public interface Executor {

    void execute(final Interactor interactor);

    void reset();
}
