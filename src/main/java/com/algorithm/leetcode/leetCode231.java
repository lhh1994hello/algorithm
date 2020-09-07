package com.algorithm.leetcode;

import org.junit.Test;

/**
 * @author lhh
 * @date 2020/9/7 21:50
 */
public class leetCode231 {

    @Test
    public void fun1() {
        int num = 81;
        int target = 3;
        boolean mi = isMi(num, target);
        System.out.println(mi);
    }

    /**
     * .num是否是target的幂次方
     *
     * @param num
     * @param target
     * @return
     */
    boolean isMi(int num, int target) {
        if (num == 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else {
            while (num % target == 0 && num / target != 0) {
                num = num / target;
            }
            if (num == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
