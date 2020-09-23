package com.rob.java.b2b;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TestSynchronized {

    @Test
     public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        SynchronizedTest summation = new SynchronizedTest();

        IntStream.range(0,1000).forEach( count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());

     }
}
