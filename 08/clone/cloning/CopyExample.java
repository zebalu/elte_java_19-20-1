package cloning;

import java.util.List;
import java.util.ArrayList;

public class CopyExample {
	
	private static int counter = 0;
	
	private final int a;
	private int b;
	private final List<String> stringList;
	
	public CopyExample(int a, int b) {
		this(a, b, new ArrayList<>());
	}
	
	private CopyExample(int a, int b, List<String> stringList) {
		this.a=a;
		this.b=b;
		++counter;
		this.stringList= new ArrayList<>(stringList);
		if(this.stringList.size()<=0) {
			this.stringList.add("object so far: "+counter);
		}
	}
	
	@Override
	public String toString() {
		return "a: "+a+" b: "+b+" "+System.identityHashCode(this)
		+" "+counter+", "+stringList.get(0);
	}
	
	
	@Override
	public CopyExample clone() {
		return new CopyExample(a, b, stringList);
	}
	
}