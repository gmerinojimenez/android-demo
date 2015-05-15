package com.gmerino.commons;

/**
 * Created by Guille on 15/05/2015.
 */
public interface Interactor {

    void run() throws Throwable;

    void onFailure(Throwable t);

}
