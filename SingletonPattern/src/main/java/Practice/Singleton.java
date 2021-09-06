package Practice;

public class Singleton {
	
	// In OOP, singleton class is a class that can have only one object (instance of class) at a time.
	// How to design a singleton class:
	// 1. make constructor as private
	// 2. write a static method that has return type of object of this singleton class(Lazy Initialiazion)
	
	private static Singleton singleton_obj;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(singleton_obj == null)
			singleton_obj = new Singleton();
		return singleton_obj;
	}
	
	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
	}
}
