package cloning;

public class MainClass {

    public static void main(String[] args) {
		CloneExample ce1 = new CloneExample(2,4);		
		CloneExample ce3 = new CloneExample(4,5);
		CloneExample ce2 = ce1.clone();
		System.out.println(ce1);
		System.out.println(ce2);
		System.out.println(ce3);
		System.out.println("-----------------------------");
		CopyExample cp1 = new CopyExample(2,4);		
		CopyExample cp3 = new CopyExample(4,5);
		CopyExample cp2 = cp1.clone();
		System.out.println(cp1);
		System.out.println(cp2);
		System.out.println(cp3);
	}

}