package ru.vasilev.cip;

import ru.vasilev.cip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
	private int value;
	
	public int getNext() {
		return value;
	}
}