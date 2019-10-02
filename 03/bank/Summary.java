package bank;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Summary {
	
	public static void main(String[] args) throws Exception {
		File f = new File(args[0]);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		List<Transfer> transferList = read(br);
		int sum = 0;
		for(Transfer t: transferList) {
			if(t.isDone()){
				sum += t.getAmount();
			}
		}
		System.out.println("all transfer: "+sum);
		System.out.println("sums: "+sumGotAmmount(transferList));
		System.out.println("account with most income: "+findKeyWithMaxValue(sumGotAmmount(transferList)));
	}
	
	private static List<Transfer> read(BufferedReader reader) throws IOException {
		List<Transfer> transferList = new ArrayList<>();
		String line = null;
		while((line = reader.readLine())!=null) {
			String[] parts = line.split(" ");
			Transfer t = new Transfer(
			    parts[0], parts[1],
				Long.parseLong(parts[2]),
				Integer.parseInt(parts[3])
			);
			transferList.add(t);
		}
		return transferList;
	}
	
	private static Map<String, Integer> sumGotAmmount(List<Transfer> transfers) {
		Map<String, Integer> result = new HashMap<>();
		for(Transfer t: transfers) {
			int sum = Integer.MIN_VALUE;
			if(result.get(t.getTarget()) != null){
				sum = result.get(t.getTarget());
			} else {
				sum = 0;
			}
			sum+=t.getAmount();
			result.put(t.getTarget(), sum);
		}
		return result;
	}
	
	private static String findKeyWithMaxValue(Map<String, Integer> map) {
		if(map.isEmpty()) {
			throw new IllegalStateException("Empty map");
		}
		String result = null;
		int max = Integer.MIN_VALUE;
		for(String key : map.keySet()) {
			if(map.get(key) > max) {
				max=map.get(key);
				result = key;
			}
		}
		System.out.println("max value is at: "+result+" is: "+max);
		return result;
	}
	
}