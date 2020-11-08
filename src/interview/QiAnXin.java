package interview;

import org.junit.Test;

import java.util.*;

public class QiAnXin {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型
     *
     * {2,3,1},
     * {2,5,3},
     * {4,2,1}
     *
     */
    public static int maxValue (int[][] matrix) {

        int compute = compute(matrix, 0, 0);

        System.out.println(compute);

        return compute+matrix[matrix[0].length-1][matrix.length-1];
    }

    public static int compute(int[][] arr,int x,int y) {

        //递归结束条件
        if (x + 1 == arr[0].length - 1 && y + 1 == arr.length -1) {
            return Math.max(arr[x++][y], arr[x][y++]);
        } else if (y == arr.length -1) {
            return compute(arr, x++, y);
        }else if (x== arr[0].length-1){
            return compute(arr,x,y++);
        }else {
            return Math.max(compute(arr, x + 1, y), compute(arr, x, y + 1));
        }
    }


    /**
     * 求两百阶层
     * @param num
     * @return
     */

    public static int jiecheng(int num) {
        if (num==1)return 1;
        return num*jiecheng(num-1);
//        Integer.MAX_VALUE;
    }

    @Test
    public void main1() {

//        int[][] arr = { {2,3,1},   {2,5,3},   {4,2,1} };

//        System.out.println(maxValue(arr));


        System.out.println(Integer.MAX_VALUE);
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        long  start = System.currentTimeMillis();

        int[] date = new int[100000000];// 用数组存放结果
        date[1] = 1;
        int weishu = 1; // 求出来的值的位数


        for (int i = 1; i <= n; i++) {
            //
            for (int j = 1; j <= weishu; j++) {
                date[j] = date[j] * i;
                System.out.println("data[j]="+date[j]);
            }
            System.out.println("位数="+weishu);
            // 确保除最高位外的每位不大于9
            for (int j = 1; j < weishu; j++) {
                if (date[j] >= 10) {
                    date[j + 1] += date[j] / 10;
                    date[j] = date[j] % 10;
                }
            }
            // 确保最高位不大于9
            while (date[weishu] >= 10) {
                weishu++;
                date[weishu] += date[weishu - 1] / 10;
                date[weishu - 1] = date[weishu - 1] % 10;
            }
        }
        System.out.println(n+"的阶乘耗时："+(System.currentTimeMillis()-start)+"毫秒");
        // 输出数组结果
        for (int k = weishu; k >= 1; k--) {
            System.out.print(date[k]);
        }
    }

    /**
     * 用maxIndex表示目前的阶乘结果的位数，temp用来暂时存放当前进行到数组里第i位的运算了，就把i与数组当前位的乘积暂存在temp里，对temp做处理，结果大于10，就向数组下一位进位，不大于10了，就自动进行下一位的运算，即i加一
     *
     * 测试结果是，计算10 0000 的阶乘时，用时会将近10分钟。2 0000的阶乘用时十几秒。其他的计算结果耗时不是特别明显。
     */
    public void BigNumber(){

    }

}
