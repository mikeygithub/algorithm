package interview;

import java.util.Scanner;

/**
 * 携程笔试
 */
public class XieCheng {


    /**
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 游游今年就要毕业了，和同学们在携程上定制了日本毕业旅行。愉快的一天行程结束后大家回到了酒店房间，这时候同学们都很口渴，石头剪刀布选出游游去楼下的自动贩卖机给大家买可乐。
     *
     * 贩卖机只支持硬币支付，且收退都只支持10 ，50，100 三种面额。一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）
     *
     * 游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。
     *
     * 如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币次数？
     *
     *
     *
     * 输入描述
     * 依次输入，
     *
     * 需要可乐的数量为 m
     *
     * 10元的张数为 a
     *
     * 50元的张数为 b
     *
     * 100元的张树为 c
     *
     * 1瓶可乐的价格为 x
     *
     * 输出描述
     * 输出当前金额下需要投入硬币的次数
     *
     * 例如需要购买2瓶可乐，每瓶可乐250圆，手里有100圆3枚，50圆4枚，10圆1枚。
     *
     * 购买第1瓶投递100圆3枚，找50圆
     *
     * 购买第2瓶投递50圆5枚
     *
     * 所以是总共需要操作8次金额投递操作
     * @param m
     * @param a
     * @param b
     * @param c
     * @param x
     * @return
     */

    /*请完成下面这个函数，实现题目要求的功能,当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int buyCoke(int m, int a, int b, int c, int x) {

        int num = 0;//操作次数

        int goodPrice = m * x;//总价

        int money = 10 * a + 50 * b + 100 * c;


        return 0;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(res);

    }
}
