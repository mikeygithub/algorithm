package thread;

public class Join {

    private class A extends Thread {

        @Override
        public void run() {
            System.out.println("A run ...");
        }
    }

    private class B extends Thread {

        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("B run ...");
        }
    }

        public void start() {

        A a = new A();

            B b = new B(a);

               b.start();

                  a.start();

        }

    public static void main(String[] args) {
        Join join = new Join();
        join.start();
    }
}
