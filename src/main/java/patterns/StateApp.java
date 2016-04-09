package patterns;

public class StateApp { 
	public static void main(String[] args) { 
		Station dp = new RadioDP(); 
		Radio radio = new Radio(); 
		radio.setStation(dp); 
	
		for (int i = 0; i < 10; i++) { 
			radio.play(); 
			radio.nextStation(); 
			} 
		} 
} 

interface Station{ 
	void play(); 
} 
//State 
class Radio7 implements Station{ 
	public void play() { 
			System.out.println("RadioDP ..."); 
		} 
} 

class RadioDP implements Station{ 
	public void play() { 
			System.out.println("Radio 7 ..."); 
		} 
} 

class RadioFM implements Station{ 
	public void play() { 
		System.out.println("RadioFM ..."); 
	} 
} 

//Context 
class Radio{ 
	Station station; 
	void setStation(Station station){ 
		this.station = station; 
	} 
	void nextStation(){ 
		if (station instanceof Radio7){ 
			setStation(new RadioDP()); 
		} 
		else if (station instanceof RadioDP){ 
			setStation(new RadioFM()); 
		} 
		else if (station instanceof RadioFM){ 
			setStation(new Radio7()); 
		} 
	} 
	void play(){ 
		station.play(); 
	} 
}
