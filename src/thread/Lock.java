package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    private ReentrantLock reentrantLock = new ReentrantLock();

//    public void demo() {
//        System.out.println("线层 "+Thread.currentThread().getName()+"　执行方法");
//          reentrantLock.lock();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("线层 "+Thread.currentThread().getName()+"　获取锁对象");
//        reentrantLock.unlock();
//        System.out.println("线层 "+Thread.currentThread().getName()+"　获取释放对象");
//    }

    public synchronized void sync() {

        System.out.println("线层 "+Thread.currentThread().getName()+"　执行方法");
        reentrantLock.lock();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            new StringBuffer(Thread.currentThread().getName()+" String"+i);
        }
        System.out.println("线层 "+Thread.currentThread().getName()+"　获取锁对象");
        reentrantLock.unlock();
        System.out.println("线层 "+Thread.currentThread().getName()+"　获取释放对象");
    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        //开启二十线层
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
//                lock.demo();
                lock.sync();
            }).start();
        }
    }
}
