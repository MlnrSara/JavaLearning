import Operations.Calculator;
import Operations.Polynome;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double[] array = {-4.0,5.0,4.0};
        int[] firstPowerArray = {0, 1, 4};
        double[] secondArray = {-2.0, -3.0, 1.0};
        int[] secondPowerArray = {0, 1, 2};

        Polynome firstPolynome = new Polynome(array, firstPowerArray);
        Polynome secondPolynome = new Polynome(secondArray, secondPowerArray);

        System.out.println("Please provide the x: ");
        Scanner console = new Scanner(System.in);
        double x = console.nextDouble();

        System.out.println("The first polinome: " + firstPolynome.toString(x));
        System.out.println("The second polinome: " + secondPolynome.toString(x));

        System.out.println("The addition of the two:\n " );
        Polynome temp = Calculator.add(firstPolynome,secondPolynome, x);
        System.out.println("Which evaluates to:\n " + Calculator.evaluate(temp, x) );


        System.out.println("The remainder of the two:\n " );
        temp = Calculator.subtract(firstPolynome,secondPolynome, x);
        System.out.println("Which evaluates to:\n " + Calculator.evaluate(temp, x) );

        System.out.println("The produce of the two:\n " + Calculator.polynomialMultiplication(firstPolynome,secondPolynome).toString(x));
        System.out.println("The first polynome divided by 2:\n " + Calculator.regularDivision(firstPolynome,2.0).toString(x));
        System.out.println("The second polynome multiplied by 4:\n " + Calculator.regularMultiplication(secondPolynome,4.0).toString(x));
        System.out.println("The quotient:\n " + Calculator.polynomialDivision(firstPolynome,secondPolynome, x).toString(x));

    }
}