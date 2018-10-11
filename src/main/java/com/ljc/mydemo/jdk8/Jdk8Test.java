package com.ljc.mydemo.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Jdk8Test {

	public static void main(String[] args) {

	}

	@Test
	public void test01() {
		new Thread(() -> System.out.println("hello lambda")).start();
		Runnable r = () -> {
			System.out.println(1);
			System.out.println(2);
		};
		new Thread(r).start();
	}

	@Test
	public void test02() {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int nextInt = random.nextInt();
			list.add(nextInt);
		}
		System.out.println(list);
		Stream<Integer> stream = list.stream().sorted().filter((s) -> s < 100);
		List<Integer> newList = stream.collect(Collectors.toList());
		System.out.println(newList);
		
		// 一个流只可以使用一次
		// 总数
		long count = list.stream().sorted().filter((s) -> s < 100).count();
		System.out.println(count);
		
		// 匹配
		boolean b = list.stream().allMatch((s) -> s < 0);
		System.out.println(b);
		boolean any = list.stream().anyMatch((s) -> s < 0);
		System.out.println(any);
		
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		System.out.println(sum);
		// 规约为一个元素
		Integer integer = list.stream().reduce((x, y) -> x + y).get();
		System.out.println(integer);
	}

	
	
	
	
	
	
	
	
	
}
