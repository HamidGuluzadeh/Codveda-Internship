import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Calculator calculator = new Calculator();

        System.out.print("Enter first number: ");
        double firstNumber = scan.nextDouble();
        System.out.print("Enter second number: ");
        double secondNumber = scan.nextDouble();

        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);

        System.out.println("Addition: " + calculator.addition());
        System.out.println("Subtraction: " + calculator.subtraction());
        System.out.println("Multiplication: " + calculator.multiplication());
        System.out.println("Division: " + calculator.division());

    }
}
