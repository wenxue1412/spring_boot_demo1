package com.edu.thread;

import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{

	private String name;

	private Chopstick left;

	private Chopstick right;

	public Philosopher(String name, Chopstick left, Chopstick right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}

	private void think() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(5);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()) {
				System.out.println(this.name + "feels hungry");
				right.take();
				System.out.println(this.name + "picks up" + right);
				left.drop();
				System.out.println(this.name + "picks up" + left);
				System.out.println(this.name + "is eating");
				think();
				System.out.println(this.name + "is thinking");
				right.drop();
				left.drop();
			}
		}catch(InterruptedException e) {
			System.out.println(this.name + " exiting via interrupt");
		}
	}

}
