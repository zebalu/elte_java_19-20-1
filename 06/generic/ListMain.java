package generic;

public class ListMain {
	
	public static void main(String[] args) {
		
		MyList l = new MyList(3);
		l.add("test");
		l.add(1);
		l.add('C');
		
		for(int i=0; i<3; ++i) {
			System.out.println(
			   "i: "+i+"="+l.get(i)+
			   " "+l.get(i)
				   .getClass().getName()
			);
		}
		
		MyList<Integer> l2 = new MyList<>(3);
		l2.add(2);
		l2.add(1);
		l2.add(3);
		for(int i=0; i<3; ++i) {
			System.out.println(
			   "i: "+i+"="+l2.get(i)+
			   " "+l2.get(i)
				   .getClass().getName()
			);
		}
		
		MyIntegerList l3 = new MyIntegerList(3);
		l3.add(2);
		l3.add(1);
		l3.add(3);
		for(int i=0; i<3; ++i) {
			System.out.println(
			   "i: "+i+"="+l3.get(i)+
			   " "+l3.get(i)
				   .getClass().getName()
			);
		}
	}
}