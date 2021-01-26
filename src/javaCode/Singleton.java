package javaCode;

public class Singleton {

	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("singleton Instance Created");
	}
	
	public static Singleton getInstace() {
		return singleton;
	}
}
