package patterns;

public class PrototypeApp {
	public static void main(String[] args) {
		Human original = new Human(25, "Dean"); 
		System.out.println(original);
		
		Human copy = (Human) original.copy(); 
		System.out.println(copy);
		
		//Copy with help interface "Copyable" 
		HumanFactory factory = new HumanFactory(copy);
		Human copy2 = factory.makeCopy();
		System.out.println(copy2); 
		
		//Copy with help factory
		factory.setPrototype(new Human(30, "Mary"));
		Human copy3 = factory.makeCopy();
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
		Human copy =  new Human(age, name);
		return copy;
	}
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}
}

class HumanFactory{
	Human human;
	
	public HumanFactory(Human human){
		setPrototype(human);
	}
	public void setPrototype(Human human){
		this.human = human;
	}
	Human makeCopy(){
		return (Human)human.copy();
	}
}