package com.edu.test;

import java.util.HashSet;
import java.util.Set;

public class Demo0823 {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 3, 1};
		int[] nums2 = { 2, 3, 4, 5};
		int[] nums3 = mixArray(nums1, nums2);
		int[] nums4 = mixArray(nums1, nums3);
		printArray(nums3);
		System.out.println("----------");
		printArray(nums4);
		System.out.println(findChildStr("abcdc"));
		System.out.println(findChildStr("cbbd"));
		System.out.println(findChildStr("babad"));
		System.out.println(findChildStr("aba"));
	}
	public static int[] mixArray(int[] nums1,int[] nums2) {
		Set<Integer> mix = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j] && !mix.contains(nums1)) {
					mix.add(nums1[i]);
				}			
			}
		}
		int[] nums = new int[mix.size()];
		int i = 0;
		for (int a : mix) {
			nums[i] = a;
			i++;
		}
		return nums;
	}
	
	public static void printArray(int[] nums) {
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	public static String findChildStr(String str) {
		String result = null;
		aa : for (int i = str.length() - 1; i >= 1; i--) {
			for (int j = 0; j < str.length() - i; j++) {
				String cStr = str.substring(j, j + i + 1);
				boolean flag = true;
				for (int k = 0; k < cStr.length() / 2; k++) {
					if (cStr.charAt(k) != cStr.charAt(cStr.length() - 1 - k)) {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					result = cStr;
					break aa;
				}
			}
		}
		return result;
	}
	
	public static String findChild(String str) {
		int len = str.length();
		if (len < 2) {
			return null;
		}
		
		for (int i = 0; i < len / 2; i++) {
			if(str.charAt(i) != str.charAt(len) - i - 1) {
				String left = findChild(str.substring(0, len - 1));
				String right = findChild(str.substring(1, len));
				
				if(null != left && null != right) {
					return left.length() > right.length() ? left : right;
				} else {
					return null != left ? left : right;
				}
			}
		}
		return str;
	}
}
