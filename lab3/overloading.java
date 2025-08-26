public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Addition of two integers: " + calc.add(5, 10));         // Output: 15
        System.out.println("Addition of three integers: " + calc.add(5, 10, 15));    // Output: 30
        System.out.println("Addition of two doubles: " + calc.add(5.5, 10.5));       // Output: 16.0
    }
}
