package service;

import org.model.Polynomial;

import java.util.ArrayList;

public class Calculator {
    public static double evaluate(Polynomial first, double x){
        double result = 0.0;
        for(int i=0; i<first.getCoefficients().size(); i++){
            result += first.getCoefficients().get(i) * Math.pow(x,i);
        }
        return result;
    }

    private static void printMessage (int maxLength, Polynomial first, Polynomial second, Polynomial result, double x, boolean operation){
        String message = "";
        for(int  i = maxLength-1; i >= 0; i--){
            message += "( ";
            boolean firstExists = false;
            if(i<=first.getCoefficients().size()-1) {
                message += first.getCoefficients().get(i) + " ";
                firstExists = true;
            }
            if(i<=second.getCoefficients().size()-1){
                if(firstExists){
                    if(second.getCoefficients().get(i)>0)
                        if(!operation)
                            message += "+ ";
                        else
                            message += "- ";
                    else
                    if(!operation)
                        message += "- ";
                    else
                        message += "+ ";
                    message += Math.abs(second.getCoefficients().get(i));
                } else
                    message += second.getCoefficients().get(i);
            }
            message += " )* " + x + "^" + i;
            if(i>0)
                message += " + ";
        }
        message += " = " + result.toString(x) + "\n";
        System.out.print(message);
    }
    public static Polynomial add(Polynomial first, Polynomial second, double x){
        int minLength = Math.min(first.getCoefficients().size(), second.getCoefficients().size());
        int maxLength = Math.max(first.getCoefficients().size(), second.getCoefficients().size());
        Polynomial result = new Polynomial();
        int i;
        for( i=0; i<minLength; i++){
            result.getCoefficients().add(first.getCoefficients().get(i) + second.getCoefficients().get(i));
        }
        int j=i;
        while(j<first.getCoefficients().size()){
            result.getCoefficients().add(first.getCoefficients().get(j));
            j++;
        }
        while (i<second.getCoefficients().size()){
            result.getCoefficients().add(second.getCoefficients().get(i));
            i++;
        }
        Calculator.printMessage(maxLength, first, second, result, x, false);
        return result;
    }

    public static Polynomial subtract(Polynomial first, Polynomial second, double x){
        int minLength = Math.min(first.getCoefficients().size(), second.getCoefficients().size());
        int maxLength = Math.max(first.getCoefficients().size(), second.getCoefficients().size());
        Polynomial result = new Polynomial();
        int i;
        for( i=0; i<minLength; i++){
            result.getCoefficients().add(first.getCoefficients().get(i) - second.getCoefficients().get(i));
        }
        int j=i;
        int sign=1;
        if(first.getCoefficients().size()==i)
            sign = -1;
        while(j<first.getCoefficients().size()){
            result.getCoefficients().add(first.getCoefficients().get(j) * sign);
            j++;
        }
        while (i<second.getCoefficients().size()){
            result.getCoefficients().add(second.getCoefficients().get(j) * sign);
            i++;
        }
        Calculator.printMessage(maxLength, first, second, result, x, true);
        return  result;
    }

    public static Polynomial polynomialMultiplication(Polynomial first, Polynomial second){
        Polynomial result = new Polynomial();
        for(int i=0; i<first.getCoefficients().size()+second.getCoefficients().size()-1; i++)
            result.getCoefficients().add(0.0);
        for(int i=0; i<first.getCoefficients().size(); i++){
            for(int j=0; j<second.getCoefficients().size(); j++) {
                double temp = first.getCoefficients().get(i) * second.getCoefficients().get(j);
                temp += result.getCoefficients().get(i+j);
                result.getCoefficients().set(i + j, temp);
            }
        }
        return result;
    }

    public static Polynomial regularMultiplication(Polynomial first, double multiplier){
        Polynomial result = new Polynomial();
        for(int i=0; i<first.getCoefficients().size(); i++){
            result.getCoefficients().add(first.getCoefficients().get(i)*multiplier);
        }
        return result;
    }

    public static Polynomial regularDivision(Polynomial first, double divider){
        Polynomial result = new Polynomial();
        for(int i=0; i<first.getCoefficients().size(); i++){
            result.getCoefficients().add(first.getCoefficients().get(i)/divider);
        }
        return result;
    }

    public static ArrayList<Polynomial> polynomialDivision(Polynomial first, Polynomial second, double x){
        ArrayList<Polynomial> result = new ArrayList<Polynomial>();
        Polynomial quotient = new Polynomial();
        for(int i=0; i<first.getCoefficients().size()-second.getCoefficients().size()+1; i++)
            quotient.getCoefficients().add(0.0);
        if(first.getCoefficients().size()<second.getCoefficients().size()){
            System.out.println("You cannot make this division.");
            return result;
        }
        Polynomial firstReversed = new Polynomial();
        Polynomial secondReversed = new Polynomial();
        for (int i=first.getCoefficients().size()-1; i>=0; i--){
            firstReversed.getCoefficients().add(first.getCoefficients().get(i));
        }
        for (int i=second.getCoefficients().size()-1; i>=0; i--){
            secondReversed.getCoefficients().add(second.getCoefficients().get(i));
        }
        for(int i=0; i<first.getCoefficients().size()-second.getCoefficients().size()+1; i++){
            Polynomial temp ;
            double factor = firstReversed.getCoefficients().get(0)/secondReversed.getCoefficients().get(0);
            quotient.getCoefficients().set(quotient.getCoefficients().size()-i-1, factor);
            temp = Calculator.regularMultiplication(secondReversed, factor);
            firstReversed = Calculator.subtract(firstReversed,temp, x);
            firstReversed.getCoefficients().remove(0);
        }
        result.add(quotient);
        Polynomial auxilliary = new Polynomial();
        for (int i=firstReversed.getCoefficients().size()-1; i>=0; i--){
            auxilliary.getCoefficients().add(firstReversed.getCoefficients().get(i));
        }
        result.add(auxilliary);
        return result;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}