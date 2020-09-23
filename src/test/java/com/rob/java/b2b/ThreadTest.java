package com.rob.java.b2b;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadTest {

    @Test
    public void testThreads() throws InterruptedException {

         Thread t = new Thread(() -> System.out.println("Hello"));
         t.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0,100).forEach( (n) -> {
                    executorService.submit(() -> System.out.println("Hello world "+ n));
                });
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

    }



    @Test
    public void testCallable() throws ExecutionException, InterruptedException {

        FactorialTask task = new FactorialTask(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future =  executorService.submit(task);

        Assert.assertEquals(120, future.get().intValue());

    }

}
