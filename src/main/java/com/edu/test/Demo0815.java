package com.edu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

public class Demo0815 {
	public static void main(String[] args) {
		tagUser();
	}

	private static void tagUser() {
		Map<String, List<String>> books = new HashMap<String, List<String>>();
		Map<String, List<String>> users = new HashMap<String, List<String>>();
		books.put("呼吸", Lists.newArrayList("科幻","美国文学"));
		books.put("时间的秩序", Lists.newArrayList("哲学","物理","社会学","科学"));
		books.put("归训与惩罚", Lists.newArrayList("社会学","哲学","历史"));
		books.put("时间与他者", Lists.newArrayList("哲学"));
		books.put("杀死一只知更鸟", Lists.newArrayList("成长","教育","美国文学"));
		books.put("坏血", Lists.newArrayList("商业","纪实","美国文学","科技"));
		books.put("枪炮、病菌与钢铁", Lists.newArrayList("人类学","历史","社会学"));
		users.put("Tom", Lists.newArrayList("呼吸","杀死一只知更鸟"));
		users.put("Jerry", Lists.newArrayList("坏血","呼吸","时间与他者","时间的秩序"));
		users.put("rick", Lists.newArrayList("枪炮、病菌与钢铁", "归训与惩罚", "时间的秩序"));
		users.put("morty", Lists.newArrayList("杀死一只知更鸟"));
		
		
		
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		for (String s : users.keySet()) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			Set<String> set = new HashSet<String>();
			for (String book : users.get(s)) {
				for (String tag : books.get(book)) {
					if (set.contains(tag)) {
						int a = map.get(tag) + 1;
						map.remove(tag);
						map.put(tag, a);
						
					} else {
						set.add(tag);
						map.put(tag, 1);
					}
				}
			}
			int max = 0;
			for (String tag : map.keySet()) {
				if (map.get(tag) >= max) {
					max = map.get(tag);
				}
			}
			List<String> tags = new ArrayList<String>();
			for (String tag : map.keySet()) {
				if (map.get(tag) == max) {
					tags.add(tag);
				}
			}	
			result.put(s, tags);
			
		}
		for (String key : result.keySet()) {
			List<String> tags1 = new ArrayList<>();
			tags1 = result.get(key);
			System.out.println(key + ":" + Lists.newArrayList(tags1));
		}
	}
	

}
