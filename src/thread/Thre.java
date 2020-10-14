package thread;

public class Thre extends Thread{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            new StringBuffer(Thread.currentThread().getName()+" String"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thre().start();
        }
    }
}
