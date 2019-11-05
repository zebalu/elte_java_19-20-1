package generic;

public class MyList<T> {
	
	private int size;
	private T[] array;
	
	public MyList(int size) {
		array = (T[]) new Object[size];
		this.size=0;
	}
	
	public void add(T element) {
		array[size]=element;
		++size;
	}
	
	public T get(int index) {
		return array[index];
	}
	
}