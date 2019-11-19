package lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;


public class Lambda {
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		List<Integer> ints = new ArrayList<>(count);
		for(int i=0; i<count; ++i) {
			ints.add(i*2);
		}
		ints.forEach(i -> {
			System.out.println("i is: "+(i+3));
		});
		System.out.println("--------------");
		ints.forEach(myConsumer());
		System.out.println("--------------");
		ints.forEach(Lambda::myConsumer2);
		System.out.println("--------------");
		ints.stream().parallel().map(i->i-1).filter(i->i%3==0)
			//.collect(Collectors.toList());
		    .forEach(System.out::println);
	}
	
	private static Consumer<Integer> myConsumer() {
		return new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println("i is: "+(i+3));
			}
		};
	}
	
	private static void myConsumer2(Integer i) {
		System.out.println("i is: "+(i+3));
	}
}
