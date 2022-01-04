package com.xiaoruiit.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxr
 * @Classname Log
 * @Description ToDo
 */
public class Log {

    public static void main(String[] args) {

        List<Logg> loginLog = new ArrayList<>();
        // 1-2
        // 0-2 登录登出时间
        loginLog.add(new Logg(1, 2));
        loginLog.add(new Logg(2, 5));
        loginLog.add(new Logg(3, 5));
        loginLog.add(new Logg(4, 6));
        loginLog.add(new Logg(4, 7));
        loginLog.add(new Logg(4, 10));
        loginLog.add(new Logg(6, 10));
        loginLog.add(new Logg(5, 8));

        int[] nums= new int[24];

        for (int i = 0; i < 24; i++) {// 时间段
            for (int j = 0; j < loginLog.size(); j++) {
                if ( i >= loginLog.get(j).loginTime  && ( i < loginLog.get(j).logoutTime  )){ //登录登出时间
                    nums[i] ++;
                }
            }

        }
        System.out.println(Arrays.toString(nums));

        int[] nums2= new int[24];

        for (int i = 0; i < loginLog.size(); i++) {
            int t = loginLog.get(i).logoutTime - loginLog.get(i).loginTime ;
            int temp = loginLog.get(i).loginTime;
            for (int j = 0; j < t; j++) {
                nums2[temp ++] ++;
            }
        }

        System.out.println(Arrays.toString(nums2));

    }
}

class Logg {
    public Logg(int loginTime, int logoutTime) {
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public int loginTime;
    public int logoutTime;
}


