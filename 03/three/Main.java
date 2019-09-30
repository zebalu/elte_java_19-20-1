package three;

import three.sub.Operation;

public class Main {
	public static void main(String[] args) {
		if(args.length>1) {
		Operation o = new Operation();
		System.out.println(o.doIt(1,2));
		}
	}
}