package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Main {

	public static void main(String[] args) {

		// creating the Map
		Map<String, String> hm = new HashMap<>();

		/* getting words from the file */
		String text1 = loadFromFile(new File("English.in.txt")); // extension should be .txt !!!
		System.out.println(text1);

		/* splitting words inside the file */
		String[] arrayOne = text1.split(" ");

		// filling the Map with keys and values
		hm.put("I", "Ya");
		hm.put("office", "ofis");
		hm.put("every", "kozhen");
		hm.put("go", "ity");
		hm.put("day", "den");
		hm.put("home", "dim");
		hm.put("to", "v");
		hm.put("return", "povertatysia");
		hm.put("my", "miy");
		hm.put(".", ".");
		hm.put("Then", "Potim");

		translateTheText(hm, arrayOne);
		System.out.println();
		System.out.println();
		System.out.println("The File is translated.");
	}

	public static void translateTheText(Map<String, String> hm, String[] arrayOne) {
		try (PrintWriter pw = new PrintWriter("Ukrainian.out.txt")) {
			
			//  printing to the console the content of arrayOne
			System.out.println(Arrays.toString(arrayOne));  
			System.out.println();
			
			//  printing the translation:  arrayOne -> Map -> print
			for (String key : arrayOne) {
				System.out.print(hm.get(key) + " ");
				pw.print(hm.get(key) + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
	}

	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}
