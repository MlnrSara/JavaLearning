public class Main {
    public static void main(String[] args) {
        double[] array = {-4.0,5.0,0.0,0.0,4.0};
        double[] secondArray = {-2.0, -3.0, 1.0};
        Polynome firstPolynome = new Polynome(array);
        Polynome secondPolynome = new Polynome(secondArray);
        System.out.println(firstPolynome.add(secondPolynome));
        System.out.println(firstPolynome.subtract(secondPolynome));
        System.out.println(firstPolynome.polynomialMultiplication(secondPolynome));
        System.out.println(firstPolynome.regularDivision(2.0));
        System.out.println((secondPolynome.regularMultiplication(4.0)));
        System.out.println(firstPolynome.polynomialDivision(secondPolynome));

    }
}