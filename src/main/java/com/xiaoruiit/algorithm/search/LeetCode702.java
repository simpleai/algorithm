package com.xiaoruiit.algorithm.search;

/**
 * tags: ['二分查找']
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode702 {

    public static void main(String[] args) {
        ArrayReader arrayReader = new ArrayReader();
        System.out.println(search(arrayReader, 9));
    }
    public static int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 10000;
        while (low <= high){
            int middle = low + ((high - low) >> 1);
            if (reader.get(middle) > 10000 || reader.get(middle) > target) {
                high = middle - 1;
            } else if (reader.get(middle) < target) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    static class ArrayReader{

        int[] arr = new int[]{-1,0,3,5,9,12};
        int get(int i){
            if (i >= arr.length){
                return Integer.MAX_VALUE;
            }
            return arr[i];
        }
    }
}
