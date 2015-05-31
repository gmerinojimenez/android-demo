package com.gmerino.commons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
