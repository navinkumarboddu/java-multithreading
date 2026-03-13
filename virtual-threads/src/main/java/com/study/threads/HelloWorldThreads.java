package com.study.threads;

import static com.study.util.CommonUtil.sleep;
import static com.study.util.LoggerUtil.log;

public class HelloWorldThreads {

    private static String result = "";

    private static void hello(){
        sleep(500);
        result = result.concat("Hello");
    }

    private static void world(){
        sleep(600);
        result = result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = Thread.ofPlatform().start(HelloWorldThreads::hello);
        Thread t2 = Thread.ofPlatform().start(HelloWorldThreads::world);

        //join
        t1.join();
        t2.join();

        log("Result is :" + result);
    }
}
