package bank;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Summary {
	
	public static void main(String[] args) throws Exception {
		File f = new File(args[0]);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine())!=null) {
			System.out.println("line: "+line);
			String[] parts = line.split(" ");
			System.out.println("parts: "+parts);
			Transfer t = new Transfer(
			    parts[0], parts[1],
				Long.parseLong(parts[2]),
				Integer.parseInt(parts[3])
			);
			System.out.println(t);
		}
		Transfer t = new Transfer(
		    "123456789112345678921234",
			"123456789112345678921235",
			1L, 10
		);
		
	}
	
}