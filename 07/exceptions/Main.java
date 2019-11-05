package exceptions;

import java.io.*;
import java.net.URL;


public class Main {
	
	private static boolean streamIsEmpty = false;
	
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = null;
		if(args.length == 0) {
			br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		} else if(!args[0].contains("://")) {
			br = new BufferedReader(new FileReader(args[0], "UTF-8"));
		} else {
			br = new BufferedReader(new InputStreamReader(
			    new URL(args[0]).openStream())
				);
		}
		try {
			while(!streamIsEmpty) {
			    int a = nextInt(br);
			    int b = nextInt(br);
			    System.out.println(a+b);
			}
		} catch(MyRuntimeException excpetion) {
			if(!streamIsEmpty) {
				throw excpetion;
			}
		}
	}
	
	private static int nextInt(BufferedReader reader) throws IOException {
		String line = null;
		while((line = reader.readLine()) != null && !streamIsEmpty) {
			if(!"".equals(line)) {
				try {
					return Integer.parseInt(line);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}
			}
		}
		streamIsEmpty = true;
		throw new MyRuntimeException("line is null");
	}
	
}