package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Call call = new Call();
        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = new FutureTask<>(call);
            new Thread(futureTask).start();
            String str = futureTask.get();
            System.out.println(str);
        }

    }
}
