package com.threadgroup;

public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("Root Thread Group");
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(threadGroup,myRunnable,"Thread 1");
        Thread thread2=new Thread(threadGroup,myRunnable,"Thread 2");
        Thread thread3=new Thread(threadGroup,myRunnable,"Thread 3");
        Thread thread4=new Thread(threadGroup,myRunnable,"Thread 4");
        Thread thread5=new Thread(threadGroup,myRunnable,"Thread 5");

        ThreadGroup threadGroup1=new ThreadGroup(threadGroup,"Child Thread Group");
        Thread thread6=new Thread(threadGroup1,myRunnable,"Thread 6");
        Thread thread7=new Thread(threadGroup1,myRunnable,"Thread 7");
        Thread thread8=new Thread(threadGroup1,myRunnable,"Thread 8");


        thread1.start();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        thread3.start();
        thread4.start();
        thread6.start();
        thread7.start();
        thread8.start();

        //threadGroup.interrupt();
        threadGroup.list();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Running "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
