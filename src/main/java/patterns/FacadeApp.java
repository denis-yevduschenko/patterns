package patterns;

public class FacadeApp {

	public static void main(String[] args) {
		Computer comp = new Computer();
		comp.run();
	}
}
// Class "Computer" is Facade, which do all work using other classes
class Computer{
	Power power = new Power();
	USB usb = new USB();
	HDD hdd = new HDD();
	
	void run(){
		power.on();
		usb.load();
		hdd.copyFromUSB(usb);
		power.off();
	}
}

class Power{
	void on(){
		System.out.println("Turn on");
	}
	void off(){
		System.out.println("Turn off");
	}
}

class USB{
	private boolean data = false;
	public boolean hasData(){
		return data;
	}
	void load(){
		data = true;
	}
	void unload(){
		data = false;
	}
}

class HDD{
	void copyFromUSB(USB usb){
		if(usb.hasData()){
			System.out.println("Copy data");
		} 
		else {
			System.out.println("Enter flash drive");
		}
	}
}