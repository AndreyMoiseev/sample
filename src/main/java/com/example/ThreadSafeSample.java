package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * This class is threadsafe.
 */
public final class ThreadSafeSample<K, V> {
	private final ConcurrentHashMap<K,V> unlimitedCache = new ConcurrentHashMap<>();

	/**
	 * Про то, чтобы выполнение было в отдельном потоке - в постановке ничего не было.
	 * Но если сделать вычисление значение на пуле потоков - ничего принципиально не изменится.
	 */
	public Future<V> compute(K key, Function<K,V> f) {
		var value = unlimitedCache.computeIfAbsent(key, f);
		return CompletableFuture.completedFuture(value);
	}
}
