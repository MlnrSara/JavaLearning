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
    public String toString(){
        return "This " + brand + " automobile was built in " + constructionYear + " and it has the color " + color + " and has " + kilometersOnBoard + " km on board";
    }
}
