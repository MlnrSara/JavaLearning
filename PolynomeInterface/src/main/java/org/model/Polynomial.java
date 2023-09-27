package org.model;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Double> coefficients = new ArrayList<Double>();
    public Polynomial(){

    }

    public ArrayList<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(ArrayList<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial(String[] indexes, String[] powers){
        for(int i=0; i<powers.length; i++){
            if(i>0 && Integer.parseInt(powers[i-1])+1!= Integer.parseInt(powers[i])){
                for(int j=1; j<Integer.parseInt(powers[i])-Integer.parseInt(powers[i-1]); j++)
                    coefficients.add(0.0);
            } else if(i==0 && Integer.parseInt(powers[i])!=0){
                for(int j=0; j<Integer.parseInt(powers[i]); j++)
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
        if(this.coefficients.get(0)!=0.0)
            message += this.coefficients.get(0) + " * "+ x + "^0";
        else {
            boolean allOK = true;
            for (Double coefficient : this.coefficients)
                if (coefficient != 0.0)
                    allOK = false;

            if(allOK)
                message = "0.0 * " + x + "^ 0";
            else
                message = message.substring(0, message.length()-2);
        }
        return message;
    }
}
