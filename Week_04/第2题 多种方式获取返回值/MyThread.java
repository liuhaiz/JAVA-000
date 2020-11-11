package com.week04.homework;

/**
 * @author lhz
 * @description
 * @date 2020/11/11
 */
/**
 * 通过私有属性返回线程执行结果
 */
class MyThread implements Runnable{

	private int retVal = 0;

	@Override
	public void run() {
		retVal = Fibo.fibo(25);
	}

	public int getRetVal() {
		return retVal;
	}

	public void setRetVal(int retVal) {
		this.retVal = retVal;
	}
}