package com.sandeep;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        AtomicInteger i=new AtomicInteger(20);

        final Task task=new Task(i);
        Thread odd=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    task.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread even=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    task.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        odd.start();
        even.start();
    }
}