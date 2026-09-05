package com.savoira.w6;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
            new NotificationDispatcher("ACC001", "Payment processed"),
            "Notifier-1"
        );

        Thread t2 = new Thread(
            new NotificationDispatcher("ACC002", "Salary credited"),
            "Notifier-2"
        );

        Thread t3 = new Thread(
            new NotificationDispatcher("ACC003", "Bill payment successful"),
            "Notifier-3"
        );

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All notifications dispatched");
    }
}