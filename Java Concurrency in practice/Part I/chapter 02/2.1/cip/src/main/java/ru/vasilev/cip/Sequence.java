package ru.vasilev.cip;

import ru.vasilev.cip.annotations.GuardedBy;
import ru.vasilev.cip.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {
	@GuardedBy("this") private int value;
	
	public synchronized int getNext() {
		return value++;
	}
}
