package patterns;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import sun.print.PrinterJobWrapper;

public class ObserverApp {
	public static void main(String[] args) {
		MeteoStation station = new MeteoStation();
		
		station.addObserver(new ConsoleObserver());
		station.addObserver(new FileObserver());
		
		station.setMeasuremets(30, 760);
		station.setMeasuremets(-10, 749);
	}
}
interface Observed{
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}

class MeteoStation implements Observed {
	int temperature;
	int pressure;
	
	List<Observer> observers = new ArrayList<>();
	
	public void setMeasuremets(int t, int p) {
		temperature = t;
		pressure = p;
		notifyObservers();
	}
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer c : observers){
			c.handleEvent(temperature, pressure);
		}
	}
}

interface Observer{
	void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{
	@Override
	public void handleEvent(int temp, int presser) {
		System.out.println("Weather changed! Temperature = " + temp 
				+ ". Pressure = " + presser + ".");
	}
}

class FileObserver implements Observer{
	@Override
	public void handleEvent(int temp, int presser) {
		File f;
		try{
			f = File.createTempFile("TempPressure", "_txt");
			PrintWriter pw = new PrintWriter(f);
			pw.print("Weather changed! Temperature = " + temp 
					+ ". Pressure = " + presser + ".");
			pw.println();
			pw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}