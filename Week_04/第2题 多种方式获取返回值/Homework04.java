package com.week04.homework;

/**
 * @author lhz
 * @description 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 * @date 2020/11/11
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Homework04 {
	public static void main(String[] args) throws InterruptedException {

		/**
		 * 1.使用CountDownLatch获取执行结果
		 */
		Integer retVal = CompletableFuture.supplyAsync(() -> {
			return Fibo.fibo(25);
		}).join();
		System.out.println("使用CompletableFuture获取执行结果：" + retVal);


		/**
		 * 2.使用CountDownLatch获取执行结果
		 * */
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Map<String, Integer> context = new HashMap<String, Integer>();
		Runnable myThread2 = new Runnable() {
			@Override
			public void run() {
				context.put("retVal", Fibo.fibo(25));
				countDownLatch.countDown();
			}
		};
		new Thread(myThread2).start();
		countDownLatch.await();
		System.out.println("使用CountDownLatch获取执行结果：" + context.get("retVal"));

		/**
		 * 3.使用Future获取执行结果
		 */
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> result = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				return Fibo.fibo(25);
			}
		});
		try {
			System.out.println("使用Future获取执行结果：" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		/**
		 * 4.通过私有属性（公有属性亦可）获取线程执行结果
		 */
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread);
		t.start();
		t.join();
		System.out.println("通过私有属性执行结果：" + myThread.getRetVal());


		/**
		 * 5.使用FutureTask创建线程获取执行结果
		 */
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
			public Integer call() throws Exception {
				return Fibo.fibo(25);
			}
		});
		new Thread(task).start();
		try {
			System.out.println("使用FutureTask创建线程获取执行结果：" + task.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		/**
		 * 6.使用FutureTask提交到线程池获取执行结果
		 */
		executor.submit(task);
		try {
			System.out.println("使用FutureTask提交到线程池获取执行结果：" + task.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executor.shutdown();


	}


}


