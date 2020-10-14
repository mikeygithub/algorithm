package thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class ProductOfConsumerByBlockingQueue {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

    private static class Producer extends Thread{
        @Override
        public void run() {
            try {
                queue.put("product");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("produce ...");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                String take = queue.take();
                System.out.println(take);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("consumer ...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}
