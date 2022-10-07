package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("file", "файл");
		map.put("block", "блок");
		map.put("dictionary", "словник");
        System.out.println("Testing map's methods");
		map.keySet().forEach(System.out::println);System.out.println("\n");
		map.values().forEach(System.out::println);System.out.println("\n");
		map.entrySet().forEach(System.out::println);System.out.println("\n");
		
		Map<String, String> map1 = new HashMap<>();

		map1.put("file", "файл");
		map1.put("block", "блок");
		map1.put("dictionary", "словник");
		System.out.println("Testing difference between HashMap, LinkedHashMap and TreeMap");
		System.out.println("HashMap:");
		map1.keySet().forEach(System.out::println);
		
		Map<String, String> map2 = new LinkedHashMap<>();

		map2.put("file", "файл");
		map2.put("block", "блок");
		map2.put("dictionary", "словник");
		System.out.println("\nLinkedHashMap:");
		map2.keySet().forEach(System.out::println);
		
		Map<String, String> map3 = new TreeMap<>();

		map3.put("file", "файл");
		map3.put("block", "блок");
		map3.put("dictionary", "словник");
		System.out.println("\nTreeMap:");
		map3.keySet().forEach(System.out::println);
		
		Properties prop=System.getProperties();
		prop.forEach((key,value)->System.out.println(key+"->" + value));
	}

}
