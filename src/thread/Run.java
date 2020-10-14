package thread;

public class Run implements Runnable{


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线层 "+name+" 正在运行");
    }

    public static void main(String[] args) {

        Run run = new Run();

        Thread thread = new Thread(run);

        thread.start();

        System.out.println("main 线层 正在运行");


    }
}
