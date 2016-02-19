package patterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

	public static void main(String[] args) {
		Shape square1 = new Square();
		Shape square2 = new Square();
		Shape triangle1 = new Triangle();
		Shape circle1 = new Circle();
		Shape circle2 = new Circle();
		
		Composite composite = new Composite();
		Composite composite1 = new Composite();
				
		composite.addComponent(square1);
		composite.addComponent(circle2);
		composite.draw();
		System.out.println();
		
		composite1.addComponent(triangle1);
		composite1.addComponent(circle2);
		composite1.addComponent(square2);
		composite1.addComponent(circle1);
		composite1.draw();
		System.out.println();
		
			
	}
}

interface Shape{
	void draw();
}

class Square implements Shape{
	@Override
	public void draw() {
		System.out.println("Привет, я квадрат!");
	}
}

class Triangle implements Shape{
	@Override
	public void draw() {
		System.out.println("Привет, я треугольник!");
	}
}

class Circle implements Shape{
	@Override
	public void draw() {
		System.out.println("Привет, я круг!");
	}
}

class Composite implements Shape{
	private List<Shape> components = new ArrayList<>();
	
	public void addComponent(Shape component){
		components.add(component);
	}
	
	public void removeComponent(Shape component){
		components.remove(component);
	}
	
	@Override
	public void draw() {
		for (Shape component : components){
			component.draw();
		}
	}
}