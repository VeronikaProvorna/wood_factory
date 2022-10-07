package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import model.Wood;

public class TestCollections {

	public static void main(String[] args) {
		Random rnd = new Random();
		System.out.println("     Test interface Collection");
		Collection<Integer> c = new Vector<>();
		for(int i=0;i<15;i++) {
			c.add(rnd.nextInt(10));
		}
		System.out.println("Collection Vector:");
		for(Integer x: c)
			System.out.printf("%d ",x);
		Collection<Integer> cñ=new TreeSet<>();
		cñ.addAll(c);
		System.out.println("\n Collection TreeSet:");
		cñ.forEach((x)->System.out.printf("%d ", x));
		System.out.println("\n");
		
		Collection<Integer> c1 = new ArrayList<>();
		Collection<Integer> c2 = new LinkedHashSet<>();
		Collection<Integer> c3 = new ArrayList<>();
		for (int i = 0; i< 5; i++) {
			c1.add(rnd.nextInt(10));
			c2.add(rnd.nextInt(10));
		}
		
		c3.addAll(c1);//= c1
		c3.removeAll(c2);
		System.out.println("c1 ="+c1 + " removeAll c2 =" + c2 + " = c3 =" + c3);
		
		c3.clear();
		c3.addAll(c2);
		c3.removeAll(c1);
		System.out.println("c2 ="+ c2 + " removeAll c1 =" + c1 + " = c3 =" + c3);
		
		c3.clear();
		c3.addAll(c1);
		c3.retainAll(c2);
		System.out.println("c1 ="+c1 + " retainAll c2 =" + c2 + " = c3 =" + c3);
		
		c3.clear();
		c3.addAll(c2);
		c3.retainAll(c1);
		System.out.println("c2 ="+c2 + " retainAll c1 =" + c1 + " = c3 =" + c3);
		
		Collection<Integer> c11 = new ArrayList<>();
		for(int i = 0; i< 7; i++) {
			c11.add(rnd.nextInt(10));
		}
		
		Collection<Integer> c22 = new LinkedHashSet<>();
		c22.addAll(c11);
		boolean b1 = c11.containsAll(c22);
		System.out.println("c11 ="+c11 + "containsAll c2 =" + c22 + " = " + b1);
		
		Collection<Integer> c33 = new LinkedHashSet<>();
		c33.addAll(c1);
		boolean b2 = c11.containsAll(c33);
		System.out.println("c11 ="+c11 + "containsAll c33=" + c33 + " = " + b2);
		
		System.out.println("\n     Test interface List");
		List<Integer> c111 = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			c111.add(rnd.nextInt(10));
		}
		
		c111.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		});
		System.out.println("c111 ="+c111);
		c111.sort((a,b) -> a - b);
		System.out.println("Sorted c111 ="+c111);
		
		Collection<Integer> coll = new ArrayDeque<>();
		System.out.println("\nMethods for Collection");
		Collections.addAll(coll, 1,-3,5,2,4,6 ,14);
		Collections.addAll(coll, new Integer[] {2,7,12});
		System.out.println("coll ="+coll);
		System.out.println("frequency(coll,2) ="+Collections.frequency(coll, 2));
		System.out.println("max ="+Collections.max(coll));
		System.out.println("min ="+Collections.min(coll));
		
		System.out.println("\nMethods for List");
		List<Integer> list = new ArrayList<>(coll);
		System.out.println("list ="+list);
		Collections.swap(list, 2, 6);
		System.out.println("swap(list,2,6) ="+list);
		Collections.sort(list);;
		System.out.println("sorted list ="+list);
		System.out.println("index of first meet of element 2 ="+Collections.binarySearch(list,2)); 
		Collections.sort(list,(a,b)->b-a);
		System.out.println("reverse sorted list ="+list);
		System.out.println("index of last meet of element 2 ="+Collections.binarySearch(list,2,(a,b)->b-a));
		Collections.reverse(list);
		System.out.println("reversed list ="+list);
		Collections.rotate(list,4);
		System.out.println("rotate(list, 4) ="+list);
		Collections.shuffle(list);
		System.out.println("schufle list ="+list);
		Collections.replaceAll(list, 2, 8);
		System.out.println("list with replaced all 2 to 8 ="+list);
		Collections.fill(list, 0);
		System.out.println("filling list with 0 ="+list);
		
		Set<Wood> set = new HashSet<>();
		set.add(new Wood("Oak",1, 1f));
		set.add(new Wood("Oak",1, 1f));
		set.add(new Wood("Oak",1, 1f));
		System.out.println("Wood HashSet:");
		set.forEach(System.out::println);
		
	}


}
