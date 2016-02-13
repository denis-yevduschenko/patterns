package patterns;

import java.util.Date;

public class FactoryMethodApp {
	public static void main(String[] args) {
		//Using Factory Method we have that client's code doesn't change
		WatchMaker maker = getMakerByName("Rome");
		
		Watch watch = maker.createWatch();
		watch.showTime();

	}
	
	public static WatchMaker getMakerByName(String maker){
		if ("Digital".equals(maker)){
			return new DigitalWatchMaker();
		}
		else if ("Rome".equals(maker)){
			return new RomeWatchMaker();
		}
		
		throw new RuntimeException("Not supported line of watches: "+ maker);
	}
}

interface Watch{
	void showTime();
}
class DigitalWatch implements Watch{
	@Override
	public void showTime() {
		System.out.println(new Date());
	}
}
class RomeWatch implements Watch{
	@Override
	public void showTime() {
		System.out.println("XX-XV");
	}
}

interface WatchMaker{
	Watch createWatch();
}
class DigitalWatchMaker implements WatchMaker{
	@Override
	public Watch createWatch() {
		return new DigitalWatch();
	}
}
class RomeWatchMaker implements WatchMaker{
	@Override
	public Watch createWatch() {
		return new RomeWatch();
	}
}