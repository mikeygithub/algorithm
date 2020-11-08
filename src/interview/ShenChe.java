package interview;

import java.util.*;

public class ShenChe {

    /**
     * 输入：(1)23(4()5)6
     * 输出：
     * 3
     * 0
     * 2
     * 5
     * 10
     * 7
     * 8
     * @param args
     */
    public static void main(String[] args) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        char[] chars = "(1)23(4()5)6".toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                leftStack.push(i);//下标
            }
        }
        for (int i = chars.length-1; i>=0;i--) {
            if (chars[i]==')'){
                rightStack.push(i);
            }
        }
        int count = Math.min(leftStack.size(),rightStack.size());

        System.out.println("===================");

        System.out.println(count);

        for (int i = 0; i < count; i++) {
            Integer pop = leftStack.pop();
            System.out.println(pop);
            Integer pop1 = rightStack.pop();
            System.out.println(pop1);
        }

    }

    public static void main2(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String[] split = str.split(",");

        if (split.length==0)return;

        int[] arr = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        System.out.println(arr[arr.length/2]);
    }

    public static void main3(String[] args) {
        String enter = "<br>";
        String tab = "<hr>";
    }
}
