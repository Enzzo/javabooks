package ru.vasilev.cip.threadsafe;

import ru.vasilev.cip.annotations.GuardedBy;
import ru.vasilev.cip.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedInteger {
	@GuardedBy("this") private int value;

	public synchronized int get() {
		return value;
	}

	public synchronized void set(int value) {
		this.value = value;
	}
}