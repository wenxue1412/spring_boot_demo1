package com.edu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Demo0905 {
	public static String longestPre(String[] strs) {
		Map<Character, Integer> c = new HashMap<>();
		String result = null;
		int count = 0;
		aa : for (int i = 0;; i++) {
			for (int j = 0; j < strs.length; j++) {
				char ch = strs[j].charAt(i);
				if (i >= strs[j].length()) {
					break aa;
				}
				if(c.containsKey(ch)) {
					c.put(ch, c.get(ch) + 1);
				} else {
					c.put(ch, 1);
				}
			}
			for (char ch : c.keySet()) {
				if (c.get(ch) == strs.length) {
					result = String.valueOf(ch) + result;
				} else {
					if(count <= 0) {
						result = null;
					} else {
						result = strs[0].substring(0, --count);
					}
					break aa;
				}
				count++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
//		String[] strs = {"arable", "arachnoid", "arbiter", "arab"};
//		System.out.println(longestPre(strs));
//		String[] anmals = {"lion","tiger", "cat", "dog"};
//		System.out.println(longestPre(anmals));
//
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
//		DFS(t1);
//		System.out.println();
//		BFS(t1);
//		findTreePath(t1);
		System.out.println(countGoodNode(t1));
		System.out.println(countGoodNode2(0, t1));
	}

	@SuppressWarnings("unused")
	private static void DFS(TreeNode root) {
		// Auto-generated method stub
		if(root == null) {
			return;
		}
		System.out.print(root.val + "->");
		if(null != root.left) {
			DFS(root.left);
		}
		if(null != root.right) {
			DFS(root.right);
		}
	}
	@SuppressWarnings("unused")
	private static void BFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root != null) {
			queue.add(root);
		}
		while(!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			System.out.print(treeNode.val + "->");
			if(null != treeNode.left) {
				queue.add(treeNode.left);
			}
			if(null != treeNode.right) {
				queue.add(treeNode.right);
			}
		}
	}
	@SuppressWarnings("unused")
	private static List<String> findTreePath(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root == null) {
			return null;
		}
		if(null != root.left) {
			result.add(String.valueOf(root.val));
			result.set(0, result.get(0) + findTreePath(root.left));
		}
		if(null != root.right) {
			result.add(String.valueOf(root.val));
			result.set(1, result.get(1) + findTreePath(root.right));
		} else {
			System.out.println(result.get(1));
		}
		return result;
	}
	static int count = 0;
	private static int countGoodNode(TreeNode root) {
		Integer max = root.val;
		List<Integer> list = new ArrayList<>();
		DFSCompare(list, max, root);
		return list.size();
	}
	private static void DFSCompare(List<Integer> list, Integer max, TreeNode root) {
		if(root == null) {
			return;
		}
		if(max == root.val) {
			list.add(max);
		}
		if(null != root.left) {
			if(root.val < root.left.val) {
				max = root.left.val;
			}
			DFSCompare(list, max, root.left);
		}
		if(null != root.right) {
			if(root.val < root.right.val) {
				max = root.right.val;
			}
			DFSCompare(list, max, root.right);
		}
		if(null == root.left && null == root.right) {
			max = 0;
		}

	}
	private static int countGoodNode2(int max, TreeNode root) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		if(root.val > 0) {
			count++;
			max = root.val;
		}
		if(null != root.left) {
			count = count + countGoodNode2(max, root.left);
		}
		if(null != root.right) {
			count = count + countGoodNode2(max, root.right);
		}
		if(null == root.left && null == root.right) {
			max = 0;
		}
		return count;
	}
}
