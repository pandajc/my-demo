package com.ljc.mydemo.kafka.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ljc.mydemo.kafka.api.Test2.MyThread;

public class Test2 {
	
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Object>> map = new HashMap<>();
		ArrayList<Object> list = new ArrayList<>();
		map.put("list", list);
		System.out.println(map);
		list.add(1);
		System.out.println(map);
		new Test2().new MyThread(map).start();
		
		System.out.println(map.hashCode());
		map.put("list", null);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
		System.out.println("null后" + map);
	}
	
	class MyThread extends Thread{
		
		private Map<String, ArrayList<Object>> map;
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("------------");
			System.out.println(map.hashCode());
			System.out.println(map);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println(map);
		}
		
		public MyThread() {
			super();
		}

		public MyThread(Map<String, ArrayList<Object>> map) {
			super();
			this.map = map;
		}
		
	}
	
}
