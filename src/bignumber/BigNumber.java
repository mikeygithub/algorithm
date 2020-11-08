package bignumber;

import java.util.Scanner;

public class BigNumber {


    /**
     * 大数相加
     * @param str1
     * @param str2
     * @return
     */
    public static String BigNumberAdd(String str1,String str2) {

        int length = Math.max(str1.length(), str2.length());

        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        //填充数组
        for (int i = 0; i < str1.length(); i++) {
            arr1[((arr1.length-1)-i)]=Integer.parseInt(String.valueOf(str1.charAt((str1.length()-1)-i)));
        }

        for (int i = 0; i < str2.length(); i++) {
            arr2[((arr2.length-1)-i)]=Integer.parseInt(String.valueOf(str2.charAt((str2.length()-1)-i)));
        }

        String sum = "";

        int carry = 0;//进位

        for (int i = length-1; i >= 0; i--) {

            int tmp = arr1[i]+arr2[i]+carry;

            //进位
            if (tmp >= 10) {
                if (tmp == 10) {
                    tmp = 0;
                } else {
                    tmp %= 10;
                }
                sum=tmp+sum;
                carry = 1;
            } else {//无需进位直接拼接
                sum=tmp+sum;
                carry = 0;
            }
        }

        if (carry == 1) sum = 1+sum;

        System.out.println(sum);

        return sum;
    }


    /**
     * 大数除法
     * @param s
     * @param s1
     */
    public static void BigNumberDiv(String s, String s1) {

    }

    /**
     *大数乘法
     * @param s
     * @param s1
     */
    public static void BigNumberMul(String s, String s1) {

    }

    /**
     * 大数减法
     * @param s
     * @param s1
     */
    public static void BigNumberSub(String s, String s1) {

    }


    /**
     * 大数阶层
     */
    public static void stratum(int n){


        int[] date = new int[100000];// 用数组存放结果

        date[1] = 1;//默认

        int weishu = 1; // 求出来的值的位数

        for (int i = 1; i <= n; i++) {//循环

            for (int j = 1; j <= weishu; j++) {//求得当前
                date[j] = date[j] * i;
            }
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

        // 输出数组结果
        for (int k = weishu; k >= 1; k--) {
            System.out.print(date[k]);
        }
    }

    public static void main(String[] args) {

        BigNumberAdd("0","00");//大数加法
        BigNumberSub("0","00");//大数减法
        BigNumberDiv("0","00");//大数除法
        BigNumberMul("0","00");//大数乘法

    }
}
