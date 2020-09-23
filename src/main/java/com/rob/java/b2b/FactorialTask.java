package com.rob.java.b2b;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {

    int number;

    public FactorialTask(int count) {
        this.number = count;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;

        for (int count = number; count > 1; count --) {
            fact = fact * count;
        }
        return fact;
    }
}
