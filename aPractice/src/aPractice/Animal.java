package aPractice;

public class Animal implements testinterface {
	
	String name;
	private int species; //종
	private String type; // 분류
	
	private int number;
	
	
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", species=" + species + ", type=" + type + ", number=" + number + "]";
	}
	
	public String myToString() {
		return "Animal [name=" + name + ", species=" + species + ", type=" + type + ", number=" + number + "]";
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpecies() {
		return species;
	}
	public void setSpecies(int species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void print() {
		System.out.println("인터페이스로 강제로 써야되는 메서드!");
	}
	
	
}
