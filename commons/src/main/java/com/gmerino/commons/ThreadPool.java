package com.gmerino.commons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Guille on 31/05/2015.
 */
public class ThreadPool {

    // Sets the amount of time an idle thread waits before terminating
    private static final int KEEP_ALIVE_TIME = 1;
    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    /*
   * Gets the number of available cores
   * (not always the same as the maximum number of cores)
   */
    private static int NUMBER_OF_CORES =
            Runtime.getRuntime().availableProcessors();

    // A queue of Runnables
    private final BlockingQueue<Runnable> mDecodeWorkQueue = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor executor /*= new ThreadPoolExecutor(poolSize, poolSize, keepAliveSecs, TimeUnit.SECONDS, w)*/;

    public ThreadPool(){
        // Creates a thread pool manager
        executor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,       // Initial pool size
                NUMBER_OF_CORES,       // Max pool size
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                mDecodeWorkQueue);
    }

    void execute(Runnable runnable) {
        executor.execute(runnable);
    }

}
