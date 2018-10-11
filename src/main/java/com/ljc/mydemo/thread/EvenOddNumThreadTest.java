package com.ljc.mydemo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddNumThreadTest {

	public int curr = 0;

	public boolean flag = false; // true-奇数 false-偶数

	public static final Lock LOCK = new ReentrantLock();

	public static void main(String[] args) {
		EvenOddNumThreadTest test = new EvenOddNumThreadTest();

		Thread even = new Thread(new EvenNumThead(test));
		even.setName("偶数");
		Thread odd = new Thread(new OddNumThread(test));
		odd.setName("奇数");
		even.start();
		odd.start();
	}

}

/**
 * 偶数
 */
class EvenNumThead implements Runnable {

	private EvenOddNumThreadTest test;

	public EvenNumThead(EvenOddNumThreadTest test) {
		this.test = test;
	}

	@Override
	public void run() {
		while (test.curr < 100) {
			if (!test.flag) {
				// synchronized (test) {

				EvenOddNumThreadTest.LOCK.lock();
				System.out.println(Thread.currentThread().getName() + "=========" + test.curr++);
				test.flag = true;
				EvenOddNumThreadTest.LOCK.unlock();
//				test.notifyAll();
				// }
			}
		}
	}
}

class OddNumThread implements Runnable {

	private EvenOddNumThreadTest test;

	public OddNumThread(EvenOddNumThreadTest test) {
		this.test = test;
	}

	@Override
	public void run() {
		while (test.curr < 100) {
			if (test.flag) {
				// synchronized (test) {
				EvenOddNumThreadTest.LOCK.lock();
				System.out.println(Thread.currentThread().getName() + "---------" + test.curr++);
				test.flag = false;
				EvenOddNumThreadTest.LOCK.unlock();
//				test.notifyAll();
				// }
			}

		}
	}

}