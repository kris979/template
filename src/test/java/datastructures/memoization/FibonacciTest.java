package datastructures.memoization;


import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci fib = new Fibonacci();

    @Test
    public void slowFib() {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(fib.slowFib(41));
        System.out.println("Time of execution in milliseconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void fastFib() {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(fib.fastFib(41));
        System.out.println("Time of execution in milliseconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }




}