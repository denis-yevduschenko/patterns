package patterns;

public class BuilderApp {

	public static void main(String[] args) {
		Director director = new Director();
		director.setBuilder(new KiaCeratoBuilder());
		Car car = director.buildCar();
		System.out.println(car);
	}
}

enum Transmition{
	MANUAL, AUTO
}

class Car {
	String make;
	Transmition transmition;
	int maxSpeed;
	
	public void setMake(String make) {
		this.make = make;
	}
	public void setTransmition(Transmition transmition) {
		this.transmition = transmition;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [make=" + make + ", transmition=" + transmition 
				+ ", maxSpeed=" + maxSpeed + "]";
	}
	
	
}

abstract class CarBuilder {
	Car car;
	void createCar(){ 
		car = new Car();
	}
	abstract void buildMake();
	abstract void buildTransmition();
	abstract void buildMaxSpeed();
	
	Car getCar(){
		return car;
	}
}

class KiaCeratoBuilder extends CarBuilder{

	@Override
	void buildMake() {
		car.setMake("Kia Cerato");
	}

	@Override
	void buildTransmition() {
		car.setTransmition(Transmition.AUTO);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(185);
	}
}

class HondaCivicBuilder extends CarBuilder{

	@Override
	void buildMake() {
		car.setMake("Honda Civic");
	}

	@Override
	void buildTransmition() {
		car.setTransmition(Transmition.MANUAL);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(198);
	}
}

class Director {
	CarBuilder builder;
	void setBuilder(CarBuilder b){
		builder = b;
	}
	
	Car buildCar(){
		builder.createCar();
		builder.buildMake();
		builder.buildTransmition();
		builder.buildMaxSpeed();
		Car car = builder.getCar();
		return car;
	}
}