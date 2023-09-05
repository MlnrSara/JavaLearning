package Model;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Vehicle {
    protected String color;
    protected String brand;
    protected int constructionYear;
    protected int numberSeats;

    public Vehicle(){
        this.color = "";
        this.brand = "";
        this.constructionYear = 0;
        this.numberSeats = 0;
    }
    public Vehicle(String col, String br, int year, int seats){
        this.color = col;
        this.brand = br;
        this.constructionYear = year;
        this.numberSeats = seats;
    }

    public String formating(){
        String[] temp = {brand, String.valueOf(constructionYear), color, String.valueOf(numberSeats)};
        String dataLine = String.join(",", temp);
        return dataLine;
    }

    public String JSONFormat(){
        return "{\n\"brand\": " + "\"" + brand + "\"\n" + "\"produced\": " + String.valueOf(constructionYear) + "\n"  + "\"color\": " +"\"" + color + "\"\n" + "\"seats\": " + String.valueOf(numberSeats) + "\n" + "}\n\n";
    }

}
