package valasztas;

public class AlreadyVoted extends Exception {
	private final String kulcs;
	
	public AlreadyVoted(String kulcs) {
		super("this id was used already: "+kulcs);
		this.kulcs=kulcs;
	}
	
	public String getKulcs() {
		return kulcs;
	}
	
}