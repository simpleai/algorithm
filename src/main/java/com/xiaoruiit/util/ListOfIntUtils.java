package com.xiaoruiit.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class ListOfIntUtils {

    public static List<List<Integer>> intToList(int[][] arr){
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tempList.add(arr[i][j]);
            }
            list.add(tempList);
        }
        return list;
    }

    public static int[][] listToInt(List<List<Integer>> list){
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> innerList = list.get(i);
            arr[i] = new int[innerList.size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = innerList.get(j);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        List<List<Integer>> lists = intToList(arr);

        int[][] ints = listToInt(lists);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }

    }
}
