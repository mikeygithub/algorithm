package swordoffer;

import java.util.Arrays;

/**
 * 排序算法
 */
public class Sort {



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

    /**
     * 直接插入排序
     *
     * 将待排序的数组划分为局部有序子数组subSorted和无序子数组subUnSorted，每次排序时从subUnSorted中挑出第一个元素，从后向前将其与subSorted各元素比较大小，按照大小插入合适的位置，插入完成后将此元素从subUnSorted中移除，重复这个过程直至subUnSorted中没有元素，总之就时从后向前，一边比较一边移动。
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

        System.out.println(Arrays.toString(arr));

    }


    /**
     * 快速排序
     * @param s
     * @param l
     * @param r
     *
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
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

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,56,44,3,2,2,4,6,7,8,6,5,3,5,7,8,53,11};


//        bubbleSort(arr);
//        straightInsertSort(arr);
        quicksort(arr,0,20);

    }

}
