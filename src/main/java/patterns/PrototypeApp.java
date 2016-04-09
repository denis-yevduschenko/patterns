package patterns;

public class PrototypeApp {
	public static void main(String[] args) {
		Humanly original = new Humanly(25, "Dean"); 
		System.out.println(original);
		
		Humanly copy = (Humanly) original.copy(); 
		System.out.println(copy);
		
		//Copy with help interface "Copyable" 
		HumanFactory factory = new HumanFactory(copy);
		Humanly copy2 = factory.makeCopy();
		System.out.println(copy2); 
		
		//Copy with help factory
		factory.setPrototype(new Humanly(30, "Mary"));
		Humanly copy3 = factory.makeCopy();
		System.out.println(copy3);
	}
}

interface Copyable{
	Object copy();	
}

class Human implements Copyable{
	int age;
	String name;
	public Human (int age, String name){
		this.age = age;
		this.name = name;
	}
	@Override
	public Object copy() {
		Humanly copy =  new Humanly(age, name);
		return copy;
	}
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}
}

class HumanFactory{
	Humanly human;
	
	public HumanFactory(Humanly human){
		setPrototype(human);
	}
	public void setPrototype(Humanly human){
		this.human = human;
	}
	Humanly makeCopy(){
		return (Humanly)human.copy();
	}
}