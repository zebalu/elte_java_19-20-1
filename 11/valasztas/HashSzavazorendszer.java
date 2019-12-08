package valasztas;

import java.util.Map;
import java.util.HashMap;

import java.util.Set;
import java.util.HashSet;

public class HashSzavazorendszer<T> implements Szavazorendszer<T> {
	private Map<Party, Integer> votes = new HashMap<>();
	private Set<T> ids = new HashSet<>();
	
	private boolean closed = false;
	
	public void szavaz(Azonosithato<T> azonosithato, Party party) throws AlreadyVoted {
		if(ids.contains(azonosithato.getKulcs())) {
			throw new AlreadyVoted(azonosithato.getKulcs().toString());
		}
		if(!closed) {
			if(votes.get(party) == null) {
				votes.put(party, 1);
			} else {
				votes.put(party, votes.get(party)+1);
			}
			ids.add(azonosithato.getKulcs());
		}
	}
	public int osszSzavazat() {
		return ids.size();
	}
	public void lezar() {
		this.closed=true;
	}
	public Party nyertes() {
		checkClosed();
		return votes.entrySet().stream()
		    .max((lhs, rhs) -> lhs.getValue() - rhs.getValue())
			.get().getKey();
	}
	public long hanySzavazat(Party party) {
		checkClosed();
		return votes.get(party) == null ? 0L : votes.get(party);
	}
	
	private void checkClosed() {
		if(!closed) {
			throw new IllegalStateException("Vote is not closed yet");
		}
	}
}