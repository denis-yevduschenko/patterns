package patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FlyweightApp {
	public static void main(String[] args) {
			
		ShapeFactory factory = new ShapeFactory();
		
		List<Shape2> shapes = new ArrayList<>();
		
		shapes.add(factory.getShape("circle"));
		shapes.add(factory.getShape("square"));
		shapes.add(factory.getShape("square"));
		shapes.add(factory.getShape("point"));
		shapes.add(factory.getShape("square"));
		shapes.add(factory.getShape("circle"));
		
		Random rand = new Random();
		for (Shape2 shape : shapes){
			int x = rand.nextInt(100);
			int y = rand.nextInt(100);
			shape.draw(x,y);
		}
	}

}
//Flyweight
interface Shape2{
	void draw (int x, int y);
}

class Point implements Shape2 {
	@Override
	public void draw(int x, int y) {
		System.out.println("("+x+","+y+"): draw point" );
	}
}

class Circle2 implements Shape2 {
	int r = 7;
	@Override
	public void draw(int x, int y) {
		System.out.println("("+x+","+y+"): draw circle with R = " + r);
	}
}

class Square2 implements Shape2 {
	int a = 10;
	@Override
	public void draw(int x, int y) {
		System.out.println("("+x+","+y+"): draw square with a = " + a);
	}
}

class ShapeFactory {
	private static final Map<String, Shape2> shapes = new HashMap<>();
	public Shape2 getShape (String shapeName){
		Shape2 shape = shapes.get(shapeName);
		if (shape == null){
			switch(shapeName){
				case "circle": 
					shape = new Circle2();
					break;
				case "square":
					shape = new Square2();
					break;
				case "point":
					shape = new Point();
					break;
			}
			shapes.put(shapeName, shape);
		}
		return shape;
	}
}