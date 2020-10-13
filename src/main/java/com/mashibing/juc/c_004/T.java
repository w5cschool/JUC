/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

package com.mashibing.juc.c_004;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class T {

	private static int count = 10;
	
	public synchronized static void m() { //这里等同于synchronized(FineCoarseLock.class)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
		//将T.class为锁
		synchronized(T.class) { //考虑一下这里写synchronized(this)是否可以？
			count --;
		}
	}

	public static void main(String[] args) {


	}
}
