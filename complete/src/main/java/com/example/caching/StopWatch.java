package com.example.caching;

import java.text.DecimalFormat;

public class StopWatch {

    /* Private Instance Variables */
    /** Stores the start time when an object of the StopWatch class is initialized. */
    private long startTime;

    /**
     * Custom constructor which initializes the {@link #startTime} parameter.
     */
    public StopWatch() {
        startTime = System.nanoTime();
    }

    /**
     * Gets the elapsed time (in seconds) since the time the object of StopWatch was initialized.
     *
     * @return Elapsed time in seconds.
     */
    public String getElapsedTime() {
        DecimalFormat df = new DecimalFormat("#0.0");
        long endTime = System.nanoTime();
        double elapsed = (double)(endTime - startTime) / 1000000000;
        startTime = System.nanoTime();
        return df.format(elapsed);
    }
}