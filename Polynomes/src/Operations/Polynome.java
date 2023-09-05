package Operations;

import java.util.ArrayList;
public class Polynome {
    public ArrayList<Double> indices = new ArrayList<Double>();
    public Polynome(){

    }
    public Polynome(double[] indexes, int[] powers){
        for(int i=0; i<powers.length; i++){
            if(i>0 && powers[i-1]+1!= powers[i]){
                for(int j=1; j<powers[i]-powers[i-1]; j++)
                    indices.add(0.0);
            }
            indices.add(powers[i], indexes[i]);
        }
    }
    public String toString(double x){
        String message = "";
        for( int i=this.indices.size()-1; i>0; i--){
            if(this.indices.get(i)==0.0)
                continue;
            message += this.indices.get(i)+ " * "+ x + "^" +i+" ";
            if(this.indices.get(i-1)<0)
                message += " ";
            else
                message += "+ ";
        }
        message += this.indices.get(0) + " * "+ x + "^0";
        return message;
    }
}
