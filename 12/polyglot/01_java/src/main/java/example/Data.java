package example;

public class Data {
	private int id;
	private String name;
	
	public Data() {
		this(-1, "missing");
	}
	
	public Data(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
}