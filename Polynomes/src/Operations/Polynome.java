package Operations;

import java.util.ArrayList;
public class Polynome {
    private ArrayList<Double> coefficients = new ArrayList<Double>();
    public Polynome(){

    }

    public ArrayList<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(ArrayList<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public Polynome(String[] indexes, String[] powers){
        for(int i=0; i<powers.length; i++){
            if(i>0 && Integer.parseInt(powers[i-1])+1!= Integer.parseInt(powers[i])){
                for(int j=1; j<Integer.parseInt(powers[i])-Integer.parseInt(powers[i-1]); j++)
                    coefficients.add(0.0);
            }
            coefficients.add(Integer.parseInt(powers[i]), Double.parseDouble(indexes[i]));
        }
    }
    public String toString(double x){
        String message = "";
        for(int i = this.coefficients.size()-1; i>0; i--){
            if(this.coefficients.get(i)==0.0)
                continue;
            message += this.coefficients.get(i)+ " * "+ x + "^" +i+" ";
            if(this.coefficients.get(i-1)<0)
                message += " ";
            else
                message += "+ ";
        }
        message += this.coefficients.get(0) + " * "+ x + "^0";
        return message;
    }
}
