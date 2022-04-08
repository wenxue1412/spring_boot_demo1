package com.edu.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo0829 {

	private static int[][] generated_2Dseg(int n, int m){
		int[][] result = new int[n][m];
		for (int i = 0; i < result.length; i++) {
			int j = 0;
			for (;;) {
				int a = (int)(Math.random() * 10);
				if (a != 1) {
					result[i][j % m] = a;
				} else {
					result[i][j % m] = a;
					break;
				}
				j++;
			}
		}
		return result;
	}
	
	private static int[][]generated_2Dseq2(int n, int m){
		int[][] result = new int[n][m + 1];
		
		for (int i = 0; i < result.length; i++) {
			int j = 0;
			Set<Integer> set = new HashSet<Integer>();
			List<Integer> list = new ArrayList<>();
			for (;;) {
				int a = (int)(Math.random() * (m + 1));
				if(!set.contains(a)) {
					set.add(a);
					list.add(a);
				}
				if (set.size() == m + 1) {
					break;
				}
			}
			for (Integer integer : list) {
				result[i][j] = integer;
				j++;
			}
		}
		return result;
	}
	
	private static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] demo = generated_2Dseg(5, 5);
		int[][] demo2 = generated_2Dseq2(3, 4);
		print2DArray(demo);
		print2DArray(demo2);
		
	}
}