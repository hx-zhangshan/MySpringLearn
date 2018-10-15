package com.koal.learning.springboot.chapter;

public class Demo {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// i是慢指针，当他的值 变化的时候才会加一
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;

				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 1, 1, 1, 2 };
		int i = removeDuplicates(nums);
		for (int j = 0; j < i; j++) {
			System.out.println(nums[j]);
		}
	}
}
