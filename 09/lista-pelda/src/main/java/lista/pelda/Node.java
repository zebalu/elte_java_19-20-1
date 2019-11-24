package lista.pelda;

/**
 * Package private segédosztály
 */
class Node<T> {
	
	private Node<T> before;
	private Node<T> after;
	private T value;
	
	
	public static <T> Node<T> createFromValue(T value) {
		return new Node<>(value);
	}
	
	public static <T> Node<T> createAfter(T value, Node<T> before) {
		if(before == null) {
			throw new IllegalArgumentException("The node can not be null");
		}
		return new Node<>(value, before, null);
	}
	
	public static <T> Node<T> createBefore(T value, Node<T> after) {
		if(after == null) {
			throw new IllegalArgumentException("The node can not be null");
		}
		return new Node<>(value, null, after);
	}
	
	public static <T> Node<T> createBetween(T value, Node<T> before, Node<T> after) {
		if(before == null) {
			throw new IllegalArgumentException("The before node can not be null");
		}
		if(after == null) {
			throw new IllegalArgumentException("The after node can not be null");
		}
		return new Node<>(value, before, after);
	}
	
	private Node(T value) {
		this(value, null, null);
	}
	
	private Node(T value, Node<T> before, Node<T> after) {
		this.value=value;
		this.before=before;
		this.after=after;
		if(before !=null) {
			connectAfter(before);
		}
		if(after != null) {
			connectBefore(after);
		}
	}
	
	private void connectAfter(Node<T> before) {
		before.after=this;
	}
	
	private void connectBefore(Node<T> after) {
		after.before=this;
	}
	
	public boolean hasAnythingBefore() {
		return before != null;
	}
	
	public boolean hasAnythingAfter() {
		return after != null;
	}

	public T getValue()  {
		return value;
	}
	
	public Node<T> next() {
		return after;
	}
	
	public Node<T> previous() {
		return before;
	}
}
