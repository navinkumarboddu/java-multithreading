package com.study.virtualthreads;

import com.study.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.study.util.LoggerUtil.log;

public class MaxVirtualThreads {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void doSomeWork(int index){
        log("started doSomeWork : " + index);
        CommonUtil.sleep(5000);
        log("Finished doSomeWork : " + index);
    }

    public static void main(String[] args) {
        int MAX_THREADS = 10;
        IntStream.rangeClosed(1, MAX_THREADS).
                forEach(i -> {
                    var threads = Thread.ofVirtual().start(() -> MaxVirtualThreads.doSomeWork(i));
                    atomicInteger.incrementAndGet();
                    log("No of threads:" + atomicInteger.get());
                });

        log("Program Completed");
        CommonUtil.sleep(10000);
    }
}
