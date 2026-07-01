public class Calculator {
    private double firstNumber;
    private double secondNumber;

    public Calculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Calculator() {

    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getFirstNumber() {
        return this.firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getSecondNumber() {
        return this.secondNumber;
    }


    public double addition() {
        return this.firstNumber + this.secondNumber;
    }

    public double subtraction() {
        return this.firstNumber - this.secondNumber;
    }

    public double multiplication() {
        return this.firstNumber * this.secondNumber;
    }

    public double division() {
        if (this.secondNumber == 0) {
            throw new ArithmeticException("Second number cannot be zero according to division!");
        }

        return this.firstNumber / this.secondNumber;
    }
}
