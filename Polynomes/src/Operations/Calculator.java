package Operations;

public class Calculator {
    public static double evaluate(Polynome first, double x){
        double result = 0.0;
        for(int i=0; i<first.indices.size(); i++){
            result += first.indices.get(i) * Math.pow(x,i);
        }
        return result;
    }
    public static Polynome add(Polynome first, Polynome second, double x){
        int minLength = Math.min(first.indices.size(), second.indices.size());
        int maxLength = Math.max(first.indices.size(), second.indices.size());
        Polynome result = new Polynome();
        int i;
        for( i=0; i<minLength; i++){
            result.indices.add(first.indices.get(i) + second.indices.get(i));
        }
        int j=i;
        while(j<first.indices.size()){
            result.indices.add(first.indices.get(j));
            j++;
        }
        while (i<second.indices.size()){
            result.indices.add(second.indices.get(j));
            i++;
        }
        String message = "";
        for( i=maxLength-1; i>=0; i--){
            message += "( ";
            boolean firstExists=false;
            if(i<=first.indices.size()-1) {
                message += first.indices.get(i) + " ";
                firstExists = true;
            }
            if(i<=second.indices.size()-1){
                if(firstExists){
                    if(second.indices.get(i)>0)
                        message += "+ ";
                    else
                        message += " ";
                    message += second.indices.get(i);
                } else
                    message += second.indices.get(i);
            }
            message += " )* " + x + "^" + i;
            if(i>0)
                message += " + ";
        }
        message += " = " + result.toString(x) + "\n";
        System.out.print(message);
        return result;
    }

    public static Polynome subtract(Polynome first, Polynome second, double x){
        int minLength = Math.min(first.indices.size(), second.indices.size());
        int maxLength = Math.max(first.indices.size(), second.indices.size());
        Polynome result = new Polynome();
        int i;
        for( i=0; i<minLength; i++){
            result.indices.add(first.indices.get(i) - second.indices.get(i));
        }
        int j=i;
        int sign=1;
        if(first.indices.size()==i)
            sign = -1;
        while(j<first.indices.size()){
            result.indices.add(first.indices.get(j) * sign);
            j++;
        }
        while (i<second.indices.size()){
            result.indices.add(second.indices.get(j) * sign);
            i++;
        }
        String message = "";
        for( i=maxLength-1; i>=0; i--){
            message += "( ";
            boolean firstExists=false;
            if(i<=first.indices.size()-1) {
                message += first.indices.get(i) + " ";
                firstExists = true;
            }
            if(i<=second.indices.size()-1){
                if(firstExists){
                    if(second.indices.get(i)>0)
                        message += "- ";
                    else
                        message += "+ " ;
                    message += Math.abs(second.indices.get(i));
                } else
                    message += second.indices.get(i);
            }
            message += " )* " + x + "^" + i;
            if(i>0)
                message += " + ";
        }
        message += " = " + result.toString(x) + "\n";
        System.out.print(message);
        return  result;
    }

    public static Polynome polynomialMultiplication(Polynome first, Polynome second){
        Polynome result = new Polynome();
        for(int i=0; i<first.indices.size()+second.indices.size()-1; i++)
            result.indices.add(0.0);
        for(int i=0; i<first.indices.size(); i++){
            for(int j=0; j<second.indices.size(); j++) {
                double temp = first.indices.get(i) * second.indices.get(j);
                temp += result.indices.get(i+j);
                result.indices.set(i + j, temp);
            }
        }
        return result;
    }

    public static Polynome regularMultiplication(Polynome first, double multiplier){
        Polynome result = new Polynome();
        for(int i=0; i<first.indices.size(); i++){
            result.indices.add(first.indices.get(i)*multiplier);
        }
        return result;
    }

    public static Polynome regularDivision(Polynome first, double divider){
        Polynome result = new Polynome();
        for(int i=0; i<first.indices.size(); i++){
            result.indices.add(first.indices.get(i)/divider);
        }
        return result;
    }

    public static Polynome polynomialDivision(Polynome first, Polynome second, double x){
        Polynome quotient = new Polynome();
        for(int i=0; i<first.indices.size()-second.indices.size()+1; i++)
            quotient.indices.add(0.0);
        if(first.indices.size()<second.indices.size()){
            System.out.println("You cannot make this division.");
            return quotient;
        }
        Polynome firstReversed = new Polynome();
        Polynome secondReversed = new Polynome();
        for (int i=first.indices.size()-1; i>=0; i--){
            firstReversed.indices.add(first.indices.get(i));
        }
        for (int i=second.indices.size()-1; i>=0; i--){
            secondReversed.indices.add(second.indices.get(i));
        }
        for(int i=0; i<first.indices.size()-second.indices.size()+1; i++){
            Polynome temp ;
            double factor = firstReversed.indices.get(0)/secondReversed.indices.get(0);
            quotient.indices.set(quotient.indices.size()-i-1, factor);
            temp = Calculator.regularMultiplication(secondReversed, factor);
            firstReversed = Calculator.subtract(firstReversed,temp, x);
            firstReversed.indices.remove(0);
        }
        return quotient;
    }


}
