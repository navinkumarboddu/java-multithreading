package com.study.threads;

import com.study.util.CommonUtil;

import static com.study.util.LoggerUtil.log;

public class ExploreThreads {

    public static void doSomeWork(){
        log("started doSomeWork");
        CommonUtil.sleep(1000);
        log("finished doSomeWork");
    }

    public static void main(String[] args) {
        var thread1 = Thread.ofPlatform().name("t1");
        var thread2 = Thread.ofPlatform().name("t2");

        var thread3 = Thread.ofPlatform().name("t3")
                        .unstarted(() -> {
                            log("Run task 3 in the background");
                        });

        thread1.start(() ->{
           log("Running Thread 1 in background...");
        });

        thread2.start(ExploreThreads::doSomeWork);

        thread3.start();
        log("Program completed");

        /*Java 8
        Runnable task = () -> {
            System.out.println("Thread runs inside Lambda...");
        };
        Thread t1 = new Thread(task);
        t1.start();


        Thread t2 = new Thread(()-> System.out.println("from direct lambda"));
        t2.start();
         */
    }
}
