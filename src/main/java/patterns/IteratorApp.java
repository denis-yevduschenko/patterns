package patterns;

public class IteratorApp {
	public static void main(String[] args){
		ConcreteAggregate concreteAggregate = new ConcreteAggregate();
		
		Iterator it = concreteAggregate.getIterator();
		
		while(it.hasNext()){
			System.out.println((String)it.next());
		}
	}
}

interface Iterator{
	boolean hasNext();
	Object next();
}

interface Container{
	Iterator getIterator();
}

class ConcreteAggregate implements Container{
	String[] tasks = {"Build house", "To give birth to a son", "To plant a tree"};

	@Override
	public Iterator getIterator() {
		return new TaskIterator();
	}
	
	private class TaskIterator implements Iterator{
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			if(index < tasks.length){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			return tasks[index++];
		}
		
	}
}


