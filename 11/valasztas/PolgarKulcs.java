package valasztas;

public class PolgarKulcs {

	private final int countryCode;
	private final String id;
	
	public PolgarKulcs(int countryCode, String id){
		this.countryCode=countryCode;
		this.id=id;
	}
	
	@Override
	public int hashCode() {
		return countryCode+31*id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(! (obj instanceof PolgarKulcs)) {
			return false;
		}
		PolgarKulcs pk = (PolgarKulcs) obj;
		return countryCode == pk.countryCode && id.equals(pk.id);
	}

}