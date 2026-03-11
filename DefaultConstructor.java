package programs;

public class DefaultConstructor {
	
	String name;
	
	public DefaultConstructor(){
		this.name = "Vinayak";
		System.out.println("Welcome to the default constructor " + name);
	}
	public static void main(String[] args) {
		DefaultConstructor object = new DefaultConstructor();
	}

}
