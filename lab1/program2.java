import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int sum = 0;
        int digitsCount = String.valueOf(num).length();

        for (int i = 0; i < digitsCount; i++) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }

        System.out.println("Sum of digits is: " + sum);
    }
} 
