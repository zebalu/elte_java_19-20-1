package bank;

public class Transfer {
	private final String from;
	private final String to;
	private final long date;
	private final int amount;
	public Transfer(
	    String from,
		String to,
		long date,
		int amount
	    ) {
		super();
		if(from.length()!=24 || 
		   to.length()!=24) {
			throw new IllegalArgumentException("too short");
		}
		if(from.equals(to)) {
			throw new IllegalArgumentException("same accounts");
		}
		if(date<=0 || amount<=0) {
			throw new IllegalArgumentException("Negative numbers");
		}
		this.from=from;
		this.to=to;
		this.date=date;
		this.amount=amount;
	}
}