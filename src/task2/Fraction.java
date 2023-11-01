package task2;

interface SumTwoFractions{
Fraction sum(Fraction operandLeft, Fraction operandRight);
}
interface MultiplicationTwoFractions{
Fraction multiplication(Fraction operandLeft, Fraction operandRight);
}
interface DifferenceTwoFractions{
Fraction difference(Fraction operandLeft, Fraction operandRight);
}
interface DivisionTwoFractions{
Fraction division(Fraction operandLeft, Fraction operandRight);
}






public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {

    }

    public Fraction(int numerator, int denominator) {
        int gcd = GCD(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("It is impossible to divide by 0!!!!");
        } else {
            this.denominator = denominator;
        }
    }

    SumTwoFractions sumTwoFractions=(Fraction operandLeft, Fraction operandRight)-> {
        int lcm = LCM(operandLeft.denominator, operandRight.denominator);
        int multiplierLeft = lcm / operandLeft.denominator;
        int multiplierRight = lcm / operandRight.denominator;
        return new Fraction(operandLeft.numerator * multiplierLeft + operandRight.numerator * multiplierRight,
                operandLeft.denominator * multiplierLeft);
    };

    MultiplicationTwoFractions multiplicationTwoFractions=(Fraction operandLeft, Fraction operandRight)->{
        Fraction f1 = new Fraction(operandLeft.numerator, operandRight.denominator);
        Fraction f2 = new Fraction(operandRight.numerator, operandLeft.denominator);
        return new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
    };

    DifferenceTwoFractions differenceTwoFractions=(Fraction operandLeft, Fraction operandRight)-> {
        int lcm = LCM(operandLeft.denominator, operandRight.denominator);
        int multiplierLeft = lcm / operandLeft.denominator;
        int multiplierRight = lcm / operandRight.denominator;
        return new Fraction(operandLeft.numerator * multiplierLeft - operandRight.numerator * multiplierRight,
                operandLeft.denominator * multiplierLeft);
    };

    DivisionTwoFractions divisionTwoFractions=(Fraction operandLeft, Fraction operandRight) ->{
        Fraction f = new Fraction(operandRight.denominator, operandRight.numerator);
        return multiplicationTwoFractions.multiplication(operandLeft, f);
    };

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }

    private static int GCD(int num1, int num2) {
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        return Math.max(num1, num2);
    }

    private static int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }
}
