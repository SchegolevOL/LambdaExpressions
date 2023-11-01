package task2;


public class App {
    public static void main(String[] args) {
        Fraction f1=new Fraction(1,2);
        Fraction f2=new Fraction(1,4);
        System.out.println(new Fraction().differenceTwoFractions.difference(f1,f2));
        System.out.println(new Fraction().multiplicationTwoFractions.multiplication(f1,f2));
        System.out.println(new Fraction().sumTwoFractions.sum(f1,f2));
        System.out.println(new Fraction().divisionTwoFractions.division(f1,f2));
    }
}