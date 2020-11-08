package interview;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ShunFeng {


    /**
     * 练习打字，现在按照时间顺序给出张三按下的键（以字符串形式给出,'<'代表回退backspace，其余字符均是张三打的字符），张三想知道最后在屏幕上显示的文本内容是什么。
     * 在文本内容为空的时候也可以按回退backspace（在这种情况下没有任何效果）。
     * <p>
     * <p>
     * <p>
     * 输入描述
     * 给定一个字符串s，代表张三所按下的按键。
     * <p>
     * 输出描述
     * 最终判断打出的字符串
     * <p>
     * <p>
     * 样例输入
     * abc<
     * 样例输出
     * ab
     */


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String Typing() {


        return "";
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String res = "";

        while (in.hasNext()) {
            String next = in.next();
            int index = next.indexOf('<');//<<<<ere
            while (index != -1) {
                //判断是否全部为退格
                if (index == 0) {
                    next = next.substring(1);
                } else {
                    next = next.substring(0, index - 1) + next.substring(index + 1);
                }
                res = next;
                index = next.indexOf('<');
            }
            if (!res.equals("")) System.out.println(res);
        }
    }
}

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个正整数n，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 正整数，范围在[1, 2147483647]之间。
 * <p>
 * 输出描述
 * 输出二进制表达式中
 * <p>
 * <<<1的个数相同且大小最接近>>></1的个数相同且大小最接近>
 * <p>
 * 的两个数，第一个为略大的数据，第二个为略小的数。
 * <p>
 * 注：
 * <p>
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */

class tow {

    static int getOneNum(String binaryString) {
        int count = 0;
        int index = binaryString.indexOf("1");
        while (index != -1) {
            count++;
            if (index == 0) {
                binaryString = binaryString.substring(1);
            } else {
                binaryString = binaryString.substring(0, index - 1) + binaryString.substring(index + 1);
            }
            index = binaryString.indexOf("1");
        }
        return count;
    }

    static int[] findNumber(int num) {

        int[] arr = new int[2];
        //计算包含1个数
        int count = getOneNum(Integer.toBinaryString(num));

        for (int i = num + 1; i < 2147483647; i++) {
            if (getOneNum(Integer.toBinaryString(i)) == count) {
                arr[0] = i;
                break;
            }
        }
        for (int i = num - 1; i > 0; i--) {
            if (getOneNum(Integer.toBinaryString(i)) == count) {
                arr[1] = i;
                break;
            }
        }


        return arr;

    }





    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = findNumber(_num);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}