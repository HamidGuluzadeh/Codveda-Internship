public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10.5, 7.3);

        System.out.println("Addition: " + calculator.addition());
        System.out.println("Subtraction: " + calculator.subtraction());
        System.out.println("Multiplication: " + calculator.multiplication());
        System.out.println("Division: " + calculator.division());

    }
}
