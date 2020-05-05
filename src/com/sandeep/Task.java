package com.sandeep;


import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    AtomicInteger start;
    AtomicInteger max;

    public Task(AtomicInteger max) {
        this.start = new AtomicInteger(0);
        this.max=max;
    }

    public void printEven() throws InterruptedException {
        synchronized (this) {
            while (start.get()<max.get()) {
                if (start.get()%2==0) {
                    System.out.println("even "+ start.getAndIncrement());
                    notify();
                }else {
                    wait();
                }
            }
        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (this) {
            while (start.get()<max.get()) {
                if (start.get()%2!=0) {
                    System.out.println("odd "+ start.getAndIncrement());
                    notify();
                }else {
                    wait();
                }
            }
        }
    }
}