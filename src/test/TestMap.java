package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("file", "����");
		map.put("block", "����");
		map.put("dictionary", "�������");
        System.out.println("Testing map's methods");
		map.keySet().forEach(System.out::println);System.out.println("\n");
		map.values().forEach(System.out::println);System.out.println("\n");
		map.entrySet().forEach(System.out::println);System.out.println("\n");
		
		Map<String, String> map1 = new HashMap<>();

		map1.put("file", "����");
		map1.put("block", "����");
		map1.put("dictionary", "�������");
		System.out.println("Testing difference between HashMap, LinkedHashMap and TreeMap");
		System.out.println("HashMap:");
		map1.keySet().forEach(System.out::println);
		
		Map<String, String> map2 = new LinkedHashMap<>();

		map2.put("file", "����");
		map2.put("block", "����");
		map2.put("dictionary", "�������");
		System.out.println("\nLinkedHashMap:");
		map2.keySet().forEach(System.out::println);
		
		Map<String, String> map3 = new TreeMap<>();

		map3.put("file", "����");
		map3.put("block", "����");
		map3.put("dictionary", "�������");
		System.out.println("\nTreeMap:");
		map3.keySet().forEach(System.out::println);
		
		Properties prop=System.getProperties();
		prop.forEach((key,value)->System.out.println(key+"->" + value));
	}

}
