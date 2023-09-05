import java.util.ArrayList;
public class Polynome {
    private ArrayList<Double> indices = new ArrayList<Double>();
    public Polynome(){

    }
    public Polynome(double[] indexes){
        for(int i=0; i<indexes.length; i++){
            indices.add(indexes[i]);
        }
    }
    public Polynome add(Polynome second){
        int minLength = Math.min(this.indices.size(), second.indices.size());
        Polynome result = new Polynome();
        int i;
        for( i=0; i<minLength; i++){
           result.indices.add(this.indices.get(i) + second.indices.get(i));
        }
        int j=i;
        while(j<this.indices.size()){
            result.indices.add(this.indices.get(j));
            j++;
        }
        while (i<second.indices.size()){
            result.indices.add(second.indices.get(j));
            i++;
        }
        return result;
    }

    public Polynome subtract(Polynome second){
        int minLength = Math.min(this.indices.size(), second.indices.size());
        Polynome result = new Polynome();
        int i;
        for( i=0; i<minLength; i++){
            result.indices.add(this.indices.get(i) - second.indices.get(i));
        }
        int j=i;
        int sign=1;
        if(this.indices.size()==i)
            sign = -1;
        while(j<this.indices.size()){
            result.indices.add(this.indices.get(j) * sign);
            j++;
        }
        while (i<second.indices.size()){
            result.indices.add(second.indices.get(j) * sign);
            i++;
        }
        return result;
    }

    public Polynome polynomialMultiplication(Polynome second){
        Polynome result = new Polynome();
        for(int i=0; i<this.indices.size()+second.indices.size()-1; i++)
            result.indices.add(0.0);
        for(int i=0; i<this.indices.size(); i++){
            for(int j=0; j<second.indices.size(); j++) {
                double temp = this.indices.get(i) * second.indices.get(j);
                temp += result.indices.get(i+j);
                result.indices.set(i + j, temp);
            }
        }
        return result;
    }

    public Polynome regularMultiplication(double multiplier){
        Polynome result = new Polynome();
        for(int i=0; i<this.indices.size(); i++){
            result.indices.add(this.indices.get(i)*multiplier);
        }
        return result;
    }

    public Polynome regularDivision(double divider){
        Polynome result = new Polynome();
        for(int i=0; i<this.indices.size(); i++){
            result.indices.add(this.indices.get(i)/divider);
        }
        return result;
    }

    public Polynome polynomialDivision(Polynome second){
        Polynome quotient = new Polynome();
        for(int i=0; i<this.indices.size()-second.indices.size()+1; i++)
            quotient.indices.add(0.0);
        if(this.indices.size()<second.indices.size()){
            System.out.println("You cannot make this division.");
            return quotient;
        }
        Polynome firstReversed = new Polynome();
        Polynome secondReversed = new Polynome();
        for (int i=this.indices.size()-1; i>=0; i--){
            firstReversed.indices.add(this.indices.get(i));
        }
        for (int i=second.indices.size()-1; i>=0; i--){
            secondReversed.indices.add(second.indices.get(i));
        }
        for(int i=0; i<this.indices.size()-second.indices.size()+1; i++){
            Polynome temp ;
            double factor = firstReversed.indices.get(0)/secondReversed.indices.get(0);
            quotient.indices.set(quotient.indices.size()-i-1, factor);
            temp = secondReversed.regularMultiplication(factor);
            firstReversed = firstReversed.subtract(temp);
            firstReversed.indices.remove(0);
        }
        return quotient;
    }

    public String toString(){
        String message = "";
        for( int i=this.indices.size()-1; i>0; i--){
            message += this.indices.get(i)+ " * X^" +i+" ";
            if(this.indices.get(i-1)<0)
                message += " ";
            else
                message += "+ ";
        }
        message += this.indices.get(0) + " * X^0";
        return message;
    }
}
