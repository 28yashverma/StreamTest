package com.first.streams;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;

public class FutureAndCompletable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> future = exec.submit(new Task());

		System.out.println(future.isDone());
		System.out.println(future.get());

		CompletableFuture<Integer> cFut = CompletableFuture.supplyAsync(new Supply(), exec);

		System.out.println(cFut.isDone());
		System.out.println(cFut.get());

		CompletableFuture<Integer> cFut1 = cFut.thenApply(new PlusOne());
		System.out.println(cFut1.get());
	}

}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return 2;
	}

}

class Supply implements Supplier<Integer> {

	@Override
	public Integer get() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return 1;
	}

}

class PlusOne implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer t) {
		return t + 1;
	}

}
