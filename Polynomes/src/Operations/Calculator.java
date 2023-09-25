package Operations;

import java.util.ArrayList;

public class Calculator {
    public static double evaluate(Polynome first, double x){
        double result = 0.0;
        for(int i=0; i<first.getCoefficients().size(); i++){
            result += first.getCoefficients().get(i) * Math.pow(x,i);
        }
        return result;
    }

    private static void printMessage (int maxLength, Polynome first, Polynome second, Polynome result, double x, boolean operation){
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
    public static Polynome add(Polynome first, Polynome second, double x){
        int minLength = Math.min(first.getCoefficients().size(), second.getCoefficients().size());
        int maxLength = Math.max(first.getCoefficients().size(), second.getCoefficients().size());
        Polynome result = new Polynome();
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
        Calculator.printMessage(maxLength, first, second, result, x, 0);
        return result;
    }

    public static Polynome subtract(Polynome first, Polynome second, double x){
        int minLength = Math.min(first.getCoefficients().size(), second.getCoefficients().size());
        int maxLength = Math.max(first.getCoefficients().size(), second.getCoefficients().size());
        Polynome result = new Polynome();
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
        Calculator.printMessage(maxLength, first, second, result, x, 1);
        return  result;
    }

    public static Polynome polynomialMultiplication(Polynome first, Polynome second){
        Polynome result = new Polynome();
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

    public static Polynome regularMultiplication(Polynome first, double multiplier){
        Polynome result = new Polynome();
        for(int i=0; i<first.getCoefficients().size(); i++){
            result.getCoefficients().add(first.getCoefficients().get(i)*multiplier);
        }
        return result;
    }

    public static Polynome regularDivision(Polynome first, double divider){
        Polynome result = new Polynome();
        for(int i=0; i<first.getCoefficients().size(); i++){
            result.getCoefficients().add(first.getCoefficients().get(i)/divider);
        }
        return result;
    }

    public static ArrayList<Polynome> polynomialDivision(Polynome first, Polynome second, double x){
        ArrayList<Polynome> result = new ArrayList<Polynome>();
        Polynome quotient = new Polynome();
        for(int i=0; i<first.getCoefficients().size()-second.getCoefficients().size()+1; i++)
            quotient.getCoefficients().add(0.0);
        if(first.getCoefficients().size()<second.getCoefficients().size()){
            System.out.println("You cannot make this division.");
            return result;
        }
        Polynome firstReversed = new Polynome();
        Polynome secondReversed = new Polynome();
        for (int i=first.getCoefficients().size()-1; i>=0; i--){
            firstReversed.getCoefficients().add(first.getCoefficients().get(i));
        }
        for (int i=second.getCoefficients().size()-1; i>=0; i--){
            secondReversed.getCoefficients().add(second.getCoefficients().get(i));
        }
        for(int i=0; i<first.getCoefficients().size()-second.getCoefficients().size()+1; i++){
            Polynome temp ;
            double factor = firstReversed.getCoefficients().get(0)/secondReversed.getCoefficients().get(0);
            quotient.getCoefficients().set(quotient.getCoefficients().size()-i-1, factor);
            temp = Calculator.regularMultiplication(secondReversed, factor);
            firstReversed = Calculator.subtract(firstReversed,temp, x);
            firstReversed.getCoefficients().remove(0);
        }
        result.add(quotient);
        Polynome auxilliary = new Polynome();
        for (int i=firstReversed.getCoefficients().size()-1; i>=0; i--){
            auxilliary.getCoefficients().add(firstReversed.getCoefficients().get(i));
        }
        result.add(auxilliary);
        return result;
    }


}
