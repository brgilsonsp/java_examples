package br.com.gilso.javatec;

public class CarPojo {
	private String name;
	private String age;
	
	
	public CarPojo(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void print() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "CarPojo [name=" + name + ", age=" + age + "]";
	}
	
	

}
