public class Plane extends Vehicle{
    private String company;
    private String name;
    private String[] classes;
    public Plane(){
        super();
        this.company = "";
        this.name = "";
        this.classes = new String[0];
    }
    public Plane(String col, String br, int year, int seats, String comp, String name, String[] cl ){
        super(col,br,year,seats);
        this.company = comp;
        this.name = name;
        this.classes = cl;
    }
    public String toString(){
        return "This " + brand + " plane was built in " + constructionYear + " and it has the color " + color + " and has " + classes.toString() + " as classes from which you can choose";
    }
}
