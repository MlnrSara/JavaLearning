import Operations.Calculator;
import Operations.Polynome;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        double[] array = {-4.0,5.0,4.0};
        int[] firstPowerArray = {0, 1, 4};
        double[] secondArray = {-2.0, -3.0, 1.0};
        int[] secondPowerArray = {0, 1, 2};
        Scanner console = new Scanner(System.in);

        System.out.println("Please give us the coefficients separated by a space: ");
        String coefficients = console.nextLine();
        String[] usefulCoefficients = coefficients.split("( )+");
        System.out.println("Please give us the powers of X separated by a space: ");
        String powers = console.nextLine();
        String[] usefulPowers = powers.split(" +");
        Polynome firstPolynome = new Polynome(usefulCoefficients, usefulPowers);

        System.out.println("Please give us the coefficients separated by a space: ");
        coefficients = console.nextLine();
        usefulCoefficients = coefficients.split("( )+");
        System.out.println("Please give us the powers of X separated by a space: ");
        powers = console.nextLine();
        usefulPowers = powers.split(" +");
        Polynome secondPolynome = new Polynome(usefulCoefficients, usefulPowers);

        System.out.println("Please provide the x: ");
        double x = console.nextDouble();
        Polynome temp;
        double factor;

        System.out.println("What operation would you like to perform? \n 1. Show the polynomials\n 2. Add\n 3. Subtract\n 4. Multiply polynomials\n 5. Multiply by a number\n 6. Divide by a number\n 7. Long division\n 8. Show options\n 9. Exit");
        System.out.println("Your option: ");
        int option = console.nextInt();
        while(option!=9) {
            switch (option) {
                case 1:
                    System.out.println("The first polynome: " + firstPolynome.toString(x));
                    System.out.println("The second polynome: " + secondPolynome.toString(x));
                    break;
                case 2:
                    System.out.println("The addition of the two:\n ");
                    temp = Calculator.add(firstPolynome, secondPolynome, x);
                    System.out.println("Which evaluates to:\n " + Calculator.evaluate(temp, x));
                    break;
                case 3:
                    System.out.println("The remainder of the two:\n ");
                    temp = Calculator.subtract(firstPolynome, secondPolynome, x);
                    System.out.println("Which evaluates to:\n " + Calculator.evaluate(temp, x));
                    break;
                case 4:
                    System.out.println("The produce of the two:\n " + Calculator.polynomialMultiplication(firstPolynome, secondPolynome).toString(x));
                    break;
                case 5:
                    factor = console.nextDouble();
                    System.out.println("The second polynome multiplied by " + factor + ":\n " + Calculator.regularMultiplication(secondPolynome, factor).toString(x));
                    break;
                case 6:
                    factor = console.nextDouble();
                    System.out.println("The first polynome divided by " + factor + ":\n " + Calculator.regularDivision(firstPolynome, factor).toString(x));
                    break;
                case 7:
                    System.out.println("The quotient:\n " );
                    ArrayList<Polynome> result = Calculator.polynomialDivision(firstPolynome, secondPolynome, x);
                    System.out.println("The quotient: " + result.get(0).toString(x) +"\nThe remainder: " + result.get(1).toString(x));
                    break;
                case 8:
                    System.out.println("What operation would you like to perform? \n 1. Show the polynomials\n 2. Add\n 3. Subtract\n 4. Multiply polynomials\n 5. Multiply by a number\n 6. Divide by a number\n 7. Long division\n 8. Show options\n 9. Exit");
                    break;
                default:
                    System.out.println("Not a valid option");
            }
            System.out.println("Your option: ");
            option = console.nextInt();
        }
        System.out.println("Thank you!");
    }
}