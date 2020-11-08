package search;

public class Solution {


    /**
     * 二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int biSearch(int[] arr,int target){

        int index = 0;
        int mid = arr.length/2;
        int end  = arr.length-1;
        while (index<=end){
            if (arr[mid] == target){
                return arr[mid];
            }else if (arr[mid]<target){//右区间
                index = mid+1;
            }else {//左区间
                end = mid-1;
            }
            mid = (index+end)/2;
        }
        return -1;
    }


}
