package ru.vasilev.cip.notthreadsafe;

import ru.vasilev.cip.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance() {
		if(instance == null) {
			instance = new ExpensiveObject();
		}
		return instance;
	}
}

class ExpensiveObject{
	
}