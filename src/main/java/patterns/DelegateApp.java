package patterns;

public class DelegateApp {

	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		//Class Waiter use other classes, delegate their methods
		waiter.setOrder(new FishChef());
		waiter.cook();
		
		waiter.setOrder(new PastryChef());
		waiter.cook();
		
		waiter.setOrder(new RoastChef());
		waiter.cook();
	}
}

interface Cooking {
	void cook();
}

class FishChef implements Cooking{
	@Override
	public void cook() {
		System.out.println("Готовим рыбу!");
	}
}

class PastryChef implements Cooking{
	@Override
	public void cook() {
		System.out.println("Готовим десерт!");
	}
}

class RoastChef implements Cooking{
	@Override
	public void cook() {
		System.out.println("Готовим мясо!");
	}
}

class Waiter{
	Cooking cooking;
	void setOrder(Cooking c){
		cooking = c;
	}
	void cook(){
		cooking.cook();
	}
}