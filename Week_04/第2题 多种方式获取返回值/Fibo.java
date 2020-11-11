package com.week04.homework;

/**
 * @author lhz
 * @description
 * @date 2020/11/11
 */
public final class Fibo {
	public static int fibo(int num) {
		if (num < 2) {
			return 1;

		}
		int m = 1;
		int n = 1;
		int result = 0;
		for (int i = 2; i <= num; i++) {
			result = m + n;
			m = n;
			n = result;
		}

		return result;
	}
}