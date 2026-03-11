package programs;

public class ParameterizedConstructor{
	
	void display() {
		System.out.println("Addition operation is done");
	}
	public ParameterizedConstructor(int a, int b) {
		display();
		int result = a + b;
		System.out.println("Output : "+ result);
	}
	public static void main(String[] args) {
		
		int value1 = 40;
		int value2 = 20;
		ParameterizedConstructor object = new ParameterizedConstructor(value1, value2);
	}
}