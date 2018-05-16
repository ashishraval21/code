package hackerrank.Implementation;

abstract class parent {

public abstract String getName();

}

public  class Child extends parent {
	String name;
	public Child(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
	
		return name;
	}
	
	
	public static void main(String[] args) {
		Child child = new Child("Rajeev");
		System.out.println(child.getName());
	}



	

}
