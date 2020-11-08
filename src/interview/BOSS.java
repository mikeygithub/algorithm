package interview;

import java.util.Arrays;
import java.util.HashMap;

public class BOSS {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param ipArr string字符串一维数组 待校验 IP 列表
     * @param blackIpArr string字符串一维数组 IP 黑名单列表
     * @return bool布尔型一维数组
     *
     * ["192.168.1.1", "192.168.1.2", "192.168.1.3"],["192.168.1.3", "192.168.1.4"]
     */
    public static boolean[] isBlackIp (String[] ipArr, String[] blackIpArr) {
        // write code here
        boolean[] blackIp = new boolean[ipArr.length];
        //排序
        Arrays.sort(blackIpArr);
        System.out.println(Arrays.toString(ipArr));
        Arrays.sort(ipArr);

        //二分查找
        for (int i = 0; i < ipArr.length; i++) {

            int index = 0;
            int end = blackIpArr.length;
            int mid = blackIpArr.length/2;
            int addressIndex = 0;
            String[] value = ipArr[i].split("\\.");

            System.out.println("查找第"+(i+1)+"个IP:"+ipArr[i]);
            //判断是否
            while (index < end) {
                //中间值
                String[] blackValue = blackIpArr[mid].split("\\.");
                System.out.println(addressIndex);
                System.out.println(value[addressIndex]+"=="+blackValue[addressIndex]);
                if (Integer.parseInt(value[addressIndex]) < Integer.parseInt(blackValue[addressIndex])) {//左区间
                    end = mid;
                    mid = (index + mid) / 2;
                    if (addressIndex==3)break;
                }

                if (Integer.parseInt(value[addressIndex]) > Integer.parseInt(blackValue[addressIndex])) {//右区间
                    index = mid;
                    mid = (index + mid) / 2;
                    if (addressIndex==3)break;
                }

                if (Integer.parseInt(value[addressIndex]) == Integer.parseInt(blackValue[addressIndex])) {//正区间

                    //判断第二个ip位置
                    addressIndex++;
                    if (addressIndex == 4) {
                        blackIp[i] = true;//对比到第四个ip位置相等则true
                        break;
                    }

                }
            }
        }

        return blackIp;
    }




    public static void main(String[] args) {
//        String[] ipArr = {"192.168.1.11", "192.168.1.2", "192.168.1.3","192.168.1.4", "192.168.1.5", "192.168.1.6"};
//        String[] blackIpArr = {"192.168.1.3", "192.168.1.4"};
//        System.out.println(Arrays.toString(isBlackIp(ipArr, blackIpArr)));
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            hashMap.put(i,i);
        }
    }



}
