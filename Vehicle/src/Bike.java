public class Bike extends Vehicle{
    private int gearNumber;
    public Bike(){
        super();
        this.gearNumber = 0;
    }
    public Bike(String col, String br, int year, int seats, int gr){
        super(col,br,year,seats);
        this.gearNumber = gr;
    }
    public String toString(){
        return "This " + brand + " bike was built in " + constructionYear + " and it has the color " + color + " and has " + gearNumber + " gear shifts";
    }
}
