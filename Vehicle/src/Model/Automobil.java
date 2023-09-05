package Model;

public class Automobil extends Vehicle {
    private double kilometersOnBoard;
    private boolean manual;
    private String registrationNo;

    public Automobil(){
        super();
        this.kilometersOnBoard = 0.0;
        this.manual = true;
        this.registrationNo = "";
    }

    public Automobil(String col, String br, int year, double km, boolean man, String reg, int seats){
        super(col,br,year, seats);
        this.kilometersOnBoard = km;
        this.manual = man;
        this.registrationNo = reg;
    }

    @Override
    public String formating(){
        String[] temp = {brand, String.valueOf(constructionYear), color, String.valueOf(numberSeats), String.valueOf(kilometersOnBoard), String.valueOf(manual), registrationNo, "NULL", "NULL", "NULL","NULL","NULL"};
        String dataLine = String.join(",", temp);
        return dataLine;
    }
}
