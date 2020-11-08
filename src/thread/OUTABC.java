package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class OUTABC {


    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
                         while (true) {
                                 if (atomicInteger.get() % 3 == 0) {
                                         try {
                                                 Thread.sleep(1000L);
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                         System.out.println("A" + (atomicInteger.getAndIncrement()));//获取当前值并自增1 是原子操作（此处可用volatile 修饰的int 类型字段代替）
                                     }
                             }
                     });

                 Thread t2 = new Thread(() -> {
                         while (true) {
                                 if (atomicInteger.get() % 3 == 1) {
                                         try {
                                                 Thread.sleep(1000L);
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                         System.out.println("B" + (atomicInteger.getAndIncrement()));
                                     }
                             }
                     });

                 Thread t3 = new Thread(() -> {
                         while (true) {
                                 if (atomicInteger.get() % 3 == 2) {
                                         try {
                                                 Thread.sleep(1000L);
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                         System.out.println("C" + (atomicInteger.getAndIncrement()));
                                     }
                             }
                     });


                 t1.start();
                 t2.start();
                 t3.start();
    }
}

