package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TianRongXin {

    /**
     * 两个单词如果包含相同的字母，次序不同，则称为字母异位词(anagram)。例如，“silent”和“listen”是字母易位词，而“apple”和“aplee”不是异位词。给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     *
     *
     * 输入描述
     * 输入两个字符串s,t
     *
     * 输出描述
     * 如果s和t是字母异位词，则输出true。如果不是，则输出false。
     *
     *
     * 样例输入
     * anagram  nagaram
     * 样例输出
     * true
     * @param args
     */
    public static void main1(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {

            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            if (str1.length() != str2.length()) {
                System.out.println("false");
                return;
            }

            char[] str1Char = str1.toCharArray();

            for (int i = 0; i < str1.length(); i++) {
                int index = str2.indexOf(str1Char[i]);
                if (index == -1) {
                    System.out.println("false");
                    return;
                }else  if (index == 0) {
                    str2 = str2.substring(1);
                } else {
                    str2 = str2.substring(0, index) + str2.substring(index);
                }
            }
            System.out.println("true");
        }
    }
    /**
     * １０００w数据查询10条
     */
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};


        for (int i = 0; i < arr.length; i++) {

        }

    }
}
