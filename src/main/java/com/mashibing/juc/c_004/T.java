/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package com.mashibing.juc.c_004;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class T {

	private static int count = 10;
	
	public synchronized static void m() { //�����ͬ��synchronized(FineCoarseLock.class)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
		//��T.classΪ��
		synchronized(T.class) { //����һ������дsynchronized(this)�Ƿ���ԣ�
			count --;
		}
	}

	public static void main(String[] args) {


	}
}