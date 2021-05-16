/*
给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 */

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[i]^nums[j]) > max) {
                    max = nums[i]^nums[j];
                }
            }
        }
        return max;
    }
}