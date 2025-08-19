package Calculator;

class Calculator {
	int add(int a, int b) {
		return a+b;
	}
	int subtract(int a,int b) {
		return a-b;
	}
	public static void main(String[]args) {
		Calculator calc= new Calculator();
		System.out.println("Addition:"+calc.add(10,5));
		System.out.println("subtraction:"+calc.subtract(10,5));
		
	}
}
