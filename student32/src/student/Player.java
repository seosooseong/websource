package student;

public class Player {
	private String name;
	private String address;
	private int age;
	private double height;
	private double weight;

	public Player() {	
	}

	public Player(String name,String address,int age, double height, double weight){
		this.name = name;
		this.address = address;
		this.age = age;
		this.height = height;
		this.weight= weight;
	}
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}

