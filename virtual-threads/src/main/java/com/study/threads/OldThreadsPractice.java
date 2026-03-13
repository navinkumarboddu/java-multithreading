package com.study.threads;

class Work extends Thread{

    @Override
    public void run() {
        System.out.println("Running the Work...");
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Running the MyThread...");
    }
}

public class OldThreadsPractice {

    public static void main(String[] args) {
        Work w1 = new Work();
        w1.run();

        MyThread m1 = new MyThread();
        m1.run();
    }
}
