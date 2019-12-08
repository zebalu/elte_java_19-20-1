package valasztas;

public class Citizen implements Azonosithato<PolgarKulcs> {
	private String name;
	private String id;
	private int age;
	private int countryCode;
	
	public Citizen(String name, String id, int age, int countryCode) {
		this.name=name;
		this.id=id;
		this.countryCode=countryCode;
		if(age<0) {
			throw new IllegalArgumentException("Age can not be negative!");
		}
		this.age=age;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age can not be negative!");
		}
		this.age=age;
	}
	
	public int getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(int countryCode) {
		this.countryCode=countryCode;
	}
	
	@Override
	public PolgarKulcs getKulcs() {
		return new PolgarKulcs(countryCode, id);
	}
}

