package iface;

import java.util.List;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class Main {

//	public static void main(String[] args) {
//		main(new String[]{"A", "B"});
    public static void main(String... args) {
		Visitable v1 = new Car("ABC-123");
		Visitable v2 = new Door();
		/*
		doVisit();
		System.out.println("After first");
		doVisit(v1);
		doVisit(v1, v2);
		doVisit(new Car("DEF-456"), new Window());
		Door d = new Door();
		doVisit(d);
		doVisit2(d, new Window());
		*/
		
		Set s = new HashSet();
		s.add(v1);
		s.add(new Car("ABC-123"));
		s.add(v2);
		s.add(v2); 
		
		System.out.println(s.size());
		System.out.println(s.contains(v1));
		System.out.println(s.contains(new Car("ABC-123")));
		System.out.println(s.contains(new Window()));
		
	}
	
	private static void doVisit(Visitable... vs) {
		for(Visitable v: vs) {
			v.visit();
		}
		System.out.println("----------------");
	}
	
	private static void doVisit2(HasVisit... vs) {
		for(HasVisit v: vs) {
			v.visit();
		}
		System.out.println("#############");
	
	}

}