package valasztas;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import java.util.Set;
import java.util.HashSet;

public class ArraySzavazorendszer<T> implements Szavazorendszer<T> {
	
	private List<Party> votes = new ArrayList<>();
	private Set<T> ids = new HashSet<>();
	private boolean closed = false;
	
	public void szavaz(Azonosithato<T> azonosithato, Party party) throws AlreadyVoted {
		if(ids.contains(azonosithato.getKulcs())) {
			throw new AlreadyVoted(azonosithato.getKulcs().toString());
		}
		if(!closed) {
			votes.add(party);
			ids.add(azonosithato.getKulcs());
		}
	}
	
	public int osszSzavazat() {
		return votes.size();
	}
	
	public void lezar() {
		closed = true;
	}
	
	public Party nyertes() {
		checkClosed();
		Map<Party, Integer> voteCount = new HashMap<>();
		for(Party party: votes) {
			if(voteCount.get(party) == null) {
				voteCount.put(party, 1);
			} else {
				voteCount.put(party, voteCount.get(party)+1);
			}
		}
		return voteCount.entrySet().stream()
		    .max((lhs, rhs) -> lhs.getValue() - rhs.getValue())
			.get().getKey();
	}
	
	public long hanySzavazat(Party party) {
		checkClosed();
		return votes.stream().filter(p -> p == party).count();
	}
	
	private void checkClosed() {
		if(!closed) {
			throw new IllegalStateException("Vote is not closed yet");
		}
	}
	
}