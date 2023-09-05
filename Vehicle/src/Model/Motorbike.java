package Model;

public class Motorbike extends Vehicle {
    private String registrationNo;
    private double decibels;
    public Motorbike(){
        super();
        this.registrationNo = "";
        this.decibels = 0;
    }
    public Motorbike(String col, String br, int year, String reg, double deci, int seats ){
        super(col, br, year, seats);
        this.registrationNo = reg;
        this.decibels = deci;
    }
    public String toString(){
        return "This " + brand + " motorbike was built in " + constructionYear + " and it has the color " + color + " and has " + registrationNo + " for its registration number";
    }
    @Override
    public String formating(){
        String[] temp = {brand, String.valueOf(constructionYear), color, String.valueOf(numberSeats), "NULL", "NULL", registrationNo, String.valueOf(decibels), "NULL","NULL","NULL","NULL"};
        String dataLine = String.join(",", temp);
        return dataLine;
    }
}
