package com.xiaoruiit.data_structure.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode202 {

    public static void main(String[] args) {
        System.out.println(isHappy(1));
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = 0;

        while (true){
            while(n != 0){
                int i = n % 10;
                temp += i * i;
                n = n / 10;
            }
            if (temp == 1){
                return true;
            }
            if (set.contains(temp)){
                return false;
            }

            set.add(temp);
            n = temp;
            temp = 0;
        }
    }
}
