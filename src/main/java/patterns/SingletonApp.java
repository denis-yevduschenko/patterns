package patterns;

public class SingletonApp {
	public static void main(String[] args){
		//Error: doesn't exist visible constructor	
		//TestSingleton ts = new TestSingleton();
		
		TestSingleton.getInstance().print();
		
		TestSingleton.getInstance().stop();
	}
}

class TestSingleton{
	public static TestSingleton instance;
	
	public static synchronized TestSingleton getInstance(){
		if (instance == null){
			instance = new TestSingleton();
		}
		return instance;
	}
	
	private TestSingleton(){	
	}
	
	public void print(){
		System.out.println(this);
	}
	
	public void stop(){
		System.out.println("Stop!");
	}
}