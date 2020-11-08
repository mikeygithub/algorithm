package sort;

import java.util.Arrays;

/**
 * 时间复杂度：T(n)=O(f(n))
 *
 * 渐进时间复杂度（asymptotic time complexity）的概念，官方的定义如下：
 * 若存在函数 f（n），使得当n趋近于无穷大时，T（n）/ f（n）的极限值为不等于零的常数，则称 f（n）是T（n）的同数量级函数。
 * 记作 T（n）= O（f（n）），称O（f（n）） 为算法的渐进时间复杂度，简称时间复杂度。
 *
 * 如何推导出时间复杂度呢？有如下几个原则：
 *  1.如果运行时间是常数量级，用常数1表示；
 *  2.只保留时间函数中的最高阶项；
 *  3.如果最高阶项存在，则省去最高阶项前面的系数。
 *
 常数阶O(1)
 对数阶O(logN)
 线性阶O(n)
 线性对数阶O(nlogN)
 平方阶O(n²)
 立方阶O(n³)
 K次方阶O(n^k)
 指数阶(2^n)
 */


/**
 * 空间复杂度
 */

/**
 * 排序算法
 */
public class Sort {


    /**
     * 快速排序
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * @param arr
     * @param left
     * @param right
     */

    public static void quicksort(int[] arr,int left,int right){
        if (left < right) {
            int low = left, height = right, x = arr[left];
            while (low < height)
            {
                while(low < height && arr[height] >= x) // 从右向左找第一个小于x的数
                    height--;
                if(low < height)
                    arr[low++] = arr[height];

                while(low < height && arr[low] < x) // 从左向右找第一个大于等于x的数
                    low++;
                if(low < height)
                    arr[height--] = arr[low];
            }
            arr[low] = x;
            quicksort(arr, left, low - 1); // 递归调用
            quicksort(arr, low + 1, right);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     *
     * 将待排序的数组划分为局部有序子数组subSorted和无序子数组subUnSorted，每次排序时从subUnSorted中挑出第一个元素，从后向前将其与subSorted各元素比较大小，
     * 按照大小插入合适的位置，插入完成后将此元素从subUnSorted中移除，重复这个过程直至subUnSorted中没有元素，总之就时从后向前，一边比较一边移动。
     * @param arr
     * O(n^2)
     */
    public static void straightInsertSort(int[] arr){

        int j = 0;
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){//插入i-1前面
                tmp = arr[i];
                for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = tmp;
            }
        }
    }

    /**
     * 选择排序
     *
     *在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     *
     * ......
     *
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * @param arr
     */
    public static void selectSort(int[] arr){
        int min;
        for (int i = 0; i < arr.length; i++) {
            min=arr[i];
            for (int j = i+1; j <arr.length; j++) {
                if (arr[j]<min){
                    int tmp = arr[i];
                    min=arr[j];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    /**
     * 希尔排序(Shell Sort)
     *
     * 前言：
     * 数据序列1： 13-17-20-42-28 利用插入排序，13-17-20-28-42. Number of swap:1;
     * 数据序列2： 13-17-20-42-14 利用插入排序，13-14-17-20-42. Number of swap:3;
     * 如果数据序列基本有序，使用插入排序会更加高效。
     *
     * 基本思想：
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
     * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
     *
     * @param arr
     */
    public static void shellSort(int[] arr){

        int incre = arr.length;

        while (true){
            incre = incre>>1;
            for (int i = 0; i < incre; i++) {
                for (int j = i; j <arr.length ; j+=incre) {
                    for (int k = j; k >i ; k-=incre) {
                        if (arr[k]<arr[k-incre]){
                            int tmp = arr[k];

                        }
                    }
                }
            }
            break;
        }

    }

    /**
     * 冒泡排序
     * @param arr
     * O(n^2)
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <  arr.length ; j++) {
                if (arr[i]<arr[j]){
                    int tmp  = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {

        int[] arr = {13,223,3,34,46,7,8,9,103,11,12,13,143,15,53};

        shellSort(arr);

    }

}
