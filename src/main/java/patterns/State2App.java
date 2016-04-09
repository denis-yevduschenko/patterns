package patterns;

public class State2App { 
	public static void main(String[] args) { 
		Humanly human = new Humanly(); 
		human.setState(new Work()); 
		
		for (int i = 0; i < 10; i++) { 
			human.doSomething(); 
		} 
	} 
} 

class Humanly{ 
	private Activity state; 

	public void setState(Activity state) { 
		this.state = state; 
	} 

	public void doSomething(){ 
		state.doSomething(this); 
	} 
} 

interface Activity { 
	public void doSomething(Humanly context); 
} 

class Work implements Activity{ 

	public void doSomething(Humanly context) { 
		System.out.println("He is working!"); 
		context.setState(new WeekEnd()); 
	} 
} 

class WeekEnd implements Activity{ 
	private int count = 0; 
	public void doSomething(Humanly context) { 
		if (count < 3){ 
			System.out.println("He is resting. (Zzz)"); 
			count++; 
		} 
		else { 
			context.setState(new Work()); 
		} 
	} 
}
