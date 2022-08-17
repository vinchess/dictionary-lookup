package com.inseinc.technicaltask;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    private static  Instant start;

    public static void startTimer(){
        start = Instant.now();
    }

    public static void endTimer(){
        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        System.err.println("Time Elapsed : " + timeElapsed + "ms");
    }

}
