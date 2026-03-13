package com.study.threads;

import com.study.util.CommonUtil;
import java.util.stream.IntStream;
import static com.study.util.LoggerUtil.log;

public class MaxThreads {

    public static void doSomeWork(int index){
        log("started doSomeWork : " + index);
        CommonUtil.sleep(5000);
        log("Finished doSomeWork : " + index);
    }

    public static void main(String[] args) {
        int MAX_THREADS = 10;
        IntStream.rangeClosed(1, MAX_THREADS).
                forEach(i -> {
                    Thread.ofPlatform().start(() -> MaxThreads.doSomeWork(i));
                });

        log("Program Completed");
    }
}
