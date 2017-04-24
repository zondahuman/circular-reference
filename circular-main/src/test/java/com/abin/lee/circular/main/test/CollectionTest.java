package com.abin.lee.circular.main.test;

import com.google.common.base.Strings;

/**
 * Created by abin on 2017/4/24 14:37.
 * circular-reference
 * com.abin.lee.circular.main.test
 */
public class CollectionTest {
    public static void main(String[] args) {
        testBit();



    }


    public static void testBit(){
       // 位运算替代求模 i & (length - 1) 替代 i % length。
        int i = 10;
        int length = 100;
        int bit = i & (length - 1);
        System.out.println("bit="+bit);
        int takeAway = i % length;
        System.out.println("takeAway="+takeAway);
    }


    public static void testJudgeNull(){
        //        String lockKey = null;
//        String lockKey = "";
        String lockKey = "abin";
        boolean flag = Strings.isNullOrEmpty(lockKey);
        System.out.println("flag="+flag);

    }
}
