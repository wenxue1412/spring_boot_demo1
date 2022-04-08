package com.edu.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo0830 {

	@SuppressWarnings("resource")
	private static List<String> getTags(int top_n) throws IOException {
		Map<String, Integer> wordcount= new HashMap<>();
		File file = new File("C:\\Users\\15208\\Pictures\\Camera Roll\\Warren.txt");
		Reader r = new FileReader(file);
		BufferedReader br = new BufferedReader(r);
		String result = br.readLine();
		while ((result = br.readLine()) != null) {
            String[] str = result.split("[ ,?,.,\\,,“,”,:,;,[,],']");
            for (String string : str) {
            	string = string.toLowerCase();
            	System.out.println(string);
            	if(wordcount.containsKey(string)) {
            		wordcount.put(string, wordcount.get(string) + 1);
            	} else {
            		wordcount.put(string, 1);
            	}
			}
        }
		List<String> top_word = new ArrayList<>();
		wordcount.put("", 0);
		wordcount.put("to", 0);
		wordcount.put("of", 0);
		wordcount.put("the", 0);
		wordcount.put("", 0);
		wordcount.put("", 0);
		for (int i = 0; i < top_n; i++) {
			int max = 0;
			for (String key : wordcount.keySet()) {
				if(wordcount.get(key) > max) {
					max = wordcount.get(key);
				}
			}
			for (String key : wordcount.keySet()) {
				if (wordcount.get(key) == max) {
					System.out.println(key);
					System.out.println(wordcount.get(key));
					top_word.add(key);
					wordcount.put(key, 0);
				}
			}
		}
		return top_word;

	}
	public static void main(String[] args) throws IOException {
		System.out.println(getTags(3));
	}
}
