package generic;

public class GenericMain {
	
	public static void main(String[] args) {
		twice("ez egy String");
		int i = getBack(1);
		System.out.println("i is: "+i);
		//i = getBack(1L);
		String s = getBack("almafa");
		System.out.println("s is: "+s);
		
	}
	
	private static <T> void twice(T t) {
		System.out.println("t is: "+t);
		System.out.println("t is: "+t);
	}
	
	private static <T> T getBack(T t) {
		System.out.println("returning t: "+t);
		return t;
	}
	
}