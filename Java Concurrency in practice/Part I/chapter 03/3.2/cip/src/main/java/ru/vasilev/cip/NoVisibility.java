package ru.vasilev.cip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoVisibility {
	
	private static boolean ready;
	private static int number;
		
	private static class ReaderThread extends Thread{
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
		@Override
		public void run() {
			
			while(!ready) {
				Thread.yield();
			}
			logger.info("asfd");
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}