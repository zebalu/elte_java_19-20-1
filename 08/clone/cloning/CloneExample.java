package cloning;

import java.util.List;
import java.util.ArrayList;

public class CloneExample implements Cloneable {
	
	private static int counter = 0;
	
	private final int a;
	private int b;
	private final List<String> stringList = new ArrayList<>();
	
	public CloneExample(int a, int b) {
		this.a=a;
		this.b=b;
		++counter;
		stringList.add("object so far: "+counter);
	}
	
	@Override
	public String toString() {
		return "a: "+a+" b: "+b+" "+System.identityHashCode(this)
		+" "+counter+", "+stringList.get(0);
	}
	
	
	@Override
	public CloneExample clone() {
		try {
			return (CloneExample)super.clone();
		} catch(CloneNotSupportedException e) {
			throw new IllegalStateException("Clone not supported", e);
		}
	}
	
}