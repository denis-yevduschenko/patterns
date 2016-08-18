package patterns;

import java.util.Arrays;

public class StrategyApp {
	public static void main(String[] args){
		StrategyClient c = new StrategyClient();
		
		int[] arr0 = {1,3,7,5,-8,7};
		c.setStrategy(new BubbleSort());
		c.executeStrategy(arr0);
		
		int[] arr1 = {4,3,8,6,-4,7};
		c.setStrategy(new IsertingSort());
		c.executeStrategy(arr1);
		
		int[] arr2 = {3,13,17,1,8,-4,3};
		c.setStrategy(new SelectionSort());
		c.executeStrategy(arr2);
	}
}

//Context
class StrategyClient{
	Sorting strategy;
	public void setStrategy(Sorting strategy){
		this.strategy = strategy;
	}
	public void executeStrategy(int[] arr){
		strategy.sort(arr);
	}
}
//Strategy
interface Sorting{
	void sort(int[] arr);
}

//Concrete strategy (Bubble Sort)
class BubbleSort implements Sorting{
	@Override
	public void sort(int[] arr) {
		System.out.println("Bubble sort");
		System.out.println("Before:\t" + Arrays.toString(arr));
		for (int barier = arr.length - 1; barier >= 0; barier--){
			for (int i = 0; i < barier; i++){
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		System.out.println("After:\t" + Arrays.toString(arr));
	}	
}

//Concrete strategy (Inserting Sort)
class IsertingSort implements Sorting{
	@Override
	public void sort(int[] arr) {
		System.out.println("Inserting sort");
		System.out.println("Before:\t" + Arrays.toString(arr));
		for (int barier = 1; barier < arr.length; barier++){
			int index = barier;
			while(index - 1 >= 0 && arr[index] < arr[index - 1]){
				int temp = arr[index];
				arr[index] = arr[index - 1];
				arr[index - 1] = temp;
				index--;
			}
		}
		System.out.println("After:\t" + Arrays.toString(arr));
	}	
}

//Concrete strategy (Selection Sort)
class SelectionSort implements Sorting{
	@Override
	public void sort(int[] arr) {
		System.out.println("Selection sort");
		System.out.println("Before:\t" + Arrays.toString(arr));
		for (int barier = 0; barier < arr.length - 1; barier++){
			for (int i = barier + 1; i < arr.length; i++){
				if(arr[i]<arr[barier]){
					int temp = arr[i];
					arr[i] = arr[barier];
					arr[barier] = temp;
				}
			}
		}
		System.out.println("After:\t" + Arrays.toString(arr));
	}	
}