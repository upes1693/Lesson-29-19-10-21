package com.threadpool;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Runnable worker=new WorkerThread("number "+i);
            executorService.execute(worker);
        }
        executorService.shutdown();
    }
}

class WorkerThread implements Runnable{
    private String message;

    public WorkerThread(String message){
        this.message=message;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+": "+this.message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " finished");
    }
}
