package hc.knowledge;

import java.util.Map;
import java.util.HashMap;

public final class Lexicon {
	
	private static final Map<String, String> LEXICON = new HashMap<>();
	
	private static final String NO_CURE = "No known cure";

	static {
		LEXICON.put("headache", "aspirin");
		LEXICON.put("sore throat", "warm tea");
		LEXICON.put("influenza", "no medicine");
	}
	
	private Lexicon() {
		throw new IllegalAccessError("No hc.knowledge.Lexicon instance for you!");
	}
	
	public static String getCureFor(String illness) {
		String cure = LEXICON.get(illness);
		if(cure == null) {
			return NO_CURE;
		}
		return cure;
	}
	
	public static boolean hasCure(String illness) {
		return LEXICON.get(illness) != null;
	}
	
	public static void registerCure (String illness, String cure) {
		LEXICON.put(illness, cure);
	}
}