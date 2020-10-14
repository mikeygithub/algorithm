package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ProductOfConsumer {

    private volatile Integer count = 0;

    ReentrantLock reentrantLock = new ReentrantLock();

    public void product(){
        while (true)
        if (count<1)
        try {
            reentrantLock.lock();
            for (int i = 0; i < 5; i++) {
                count++;
                System.out.println("生产 "+i);
            }
            System.out.println("生产者线层生产　"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public void consumer(){
        while (true)
        if (count>=5)
        try {
            reentrantLock.lock();
            for (int i = 0; i < 5; i++) {
                count--;
                System.out.println("消费 "+i);
            }
            System.out.println("消费者线层消费　"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ProductOfConsumer productOfConsumer = new ProductOfConsumer();

        new Thread(()->{
            productOfConsumer.product();
        }).start();

        new Thread(()->{
            productOfConsumer.consumer();
        }).start();
    }
}
