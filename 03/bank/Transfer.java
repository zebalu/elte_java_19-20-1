package bank;

/**
 * A Transfer osztály egy átutalást jelképez.
 */
public class Transfer {
	
	/** A forrásszámla */
	private final String from;
	
	/** A cél számla */
	private final String to;
	
	/** Az átutalás dátumát jelképező mező (az 1970.01.01 00:00:00.000 -óta eltelt milliszekundomok száma. */
	private long date;
	
	/** Az átutalás összege */
	private final int amount;
	
	/** A konstruktor hozza létre az objektumot, és állítja be a kezdeti értékeket.
	 *  Ebben az objektumban csak az átutlás dátuma változtatható a jövőben.
	 * @param from a forrásszámla, 24 karakteres String
	 * @param to a célszámla, 24 karakteres String
	 * @param date poziív szám, mely az 
	 *        1970.01.01 00:00:00.000 -óta eltelt milliszekundomok száma
	 * @param amount az átutalás összege, pozitív szám
	 */
	public Transfer(String from, String to, long date, int amount) {
		Transfer.validateParams(from, to, date, amount);
		this.from=from;
		this.to=to;
		this.date=date;
		this.amount=amount;
	}
	
	/** Ha bármely argumentum elhasal egy ellenőrzésen, Exception-t dob.*/
	private static void validateParams(String from, String to, long date, int amount) {
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
	}
	
	/** Visszaadja az átutalás összegét.
	 * @return int az átutalás összege
	 */
	public int getAmount() {
		return amount;
	}
	
	/** Megmondja az átutalás lezajlásának idejét
	 * @return long az átutalás ideje, amit az 1970.01.01 00:00:00.000 -óta eltelt milliszekundomok száma
	 */
	public long getDate() {
		return date;
	}
	
	/** Beállítja az átutalás idejét.
	 * @param date az 1970.01.01 00:00:00.000 -óta eltelt milliszekundomok száma
	 */
	public void setDate(long date) {
		if(date<=0) {
			throw new IllegalArgumentException("Negative numbers");
		}
		this.date=date;
	}
	
	/** Megmondja, hogy az átutalás lezajlott-e már.
	 * @return boolean true, ha az átutalás a múltban történt
	 */
	public boolean isDone() {
		System.out.println(date+"\t"+System.currentTimeMillis());
		return date < System.currentTimeMillis();
	}
	
	/** Megmondja, hogy mi a célszámla-
	 * @return String a célszámla
	 */
	public String getTarget() {
		return to;
	}
}