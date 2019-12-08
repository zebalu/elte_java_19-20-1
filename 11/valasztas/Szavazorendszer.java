package valasztas;

public interface Szavazorendszer<T> {
	void szavaz(Azonosithato<T> azonosithato, Party party) throws AlreadyVoted;
	public int osszSzavazat();
	public void lezar();
	public Party nyertes();
	public long hanySzavazat(Party party);
}