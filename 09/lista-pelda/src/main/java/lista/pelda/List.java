package lista.pelda;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public List(@SuppressWarnings("unchecked") T... values) {
		if(values == null || values.length == 0) {
			throw new IllegalArgumentException("list must have values");
		}
		head = tail = Node.createFromValue(values[0]);
		for(int i=1; i<values.length; ++i) {
			tail = Node.createAfter(values[i], tail);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private Node<T> current = head;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}
			
			@Override
			public T next() {
				T value = current.getValue();
				current = current.next();
				return value;
			}
			
		};
	}

}
