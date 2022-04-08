package com.edu.test;

import java.util.ArrayList;
import java.util.List;

public class Demo0822 {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 4, 6, 9 };
		System.out.println(serchInsert(nums, 4));
		System.out.println(serchInsert(nums, 9));
		System.out.println(serchInsert(nums, 5));
		System.out.println(serchInsert(nums, 10));
		System.out.println(serchInsert(nums, 0));
		int[] nums2 = { 1, 3, 3, 3, 4, 4, 6, 9 };
		System.out.println(removeDuplicates(nums2));
		System.out.println(removeDuplicates_teach(nums2));
		printYHSJ(6);
		String str = "Hello World FINE THANK YOU AND YOU";
		System.out.println(countWord(str));
	}

	private static int serchInsert(int[] nums, int target) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				index = i;
				break;
			} else {
				index = nums.length;
			}
		}
		return index;
	}

	private static int removeDuplicates(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] == nums[j]) {
					for (int k = j; k < nums.length - 1; k++) {
						nums[k] = nums[k + 1];
					}
					j--;
					length--;
				}
			}
		}
		return length;
	}
	private static int removeDuplicates_teach(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[index] != nums[i]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
	private static void printYHSJ(int high) {
		int yhsj[][] = new int[high][high];
		yhsj[0][0] = 1;
		yhsj[1][0] = 1;
		yhsj[1][1] = 1;
		for (int i = 2; i < yhsj.length; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || i == j) {
					yhsj[i][j] = 1;
				} else {
					yhsj[i][j] = yhsj[i - 1][j - 1] + yhsj[i - 1][j];
				}
			}
		}
		for (int i = 0; i < high; i++) {
			for (int j = 0; j <= high; j++) {
				if (j == high - i){
					for (int a : yhsj[i]) {
						if (a != 0) {
							System.out.print(a + " ");
						}
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	private static List<Integer> countWord(String str) {
		List<Integer> list = new ArrayList<Integer>();
		String strs[] = str.split(" ");
		for (String s : strs) {
			list.add(s.length());
		}
		return list;
	}
}
