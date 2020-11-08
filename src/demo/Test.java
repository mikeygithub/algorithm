package demo;

public class Test extends Demo{


    public static int fibonacci(int n){
        if (n==0)return 0;
        if (n==2||n==1){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
    }


    public static int fib(int n) {


        if (n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }

        int number = 0;int a = 0,b=1;

        while(n>=2){
            number=(a+b)%1000000007;
            a=b;
            b=number;
            n--;
        }

        return number;
    }
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int fibonacci = fibonacci(i);
            System.out.print(fibonacci+",");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int fibonacci = fib(i);
            System.out.print(fibonacci+",");
        }
    }
}
