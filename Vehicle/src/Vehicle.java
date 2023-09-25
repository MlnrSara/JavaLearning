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

    public String formatting(){
        String[] temp = {brand, String.valueOf(constructionYear), color, String.valueOf(numberSeats)};
        String dataLine = String.join(",", temp);
        return dataLine;
    }

    public String JSONFormat(){
        return "{\n\"brand\": " + "\"" + brand + "\"\n" + "\"produced\": " + String.valueOf(constructionYear) + "\n"  + "\"color\": " +"\"" + color + "\"\n" + "\"seats\": " + String.valueOf(numberSeats) + "\n" + "}\n\n";
    }
    public static void main(String[] args){
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Automobil mas1 = new Automobil("blue", "Toyota", 2020, 1000, true, "CJ05GHK", 5);
        Motorbike moto1 = new Motorbike("gray", "Yamaha", 1997, "B238FGC", 80, 1);
        Plane avi1 = new Plane();
        Bike bici1 = new Bike("red", "Pegasus", 2000, 1, 5);
        vehicles.add(mas1);
        vehicles.add(moto1);
        vehicles.add(avi1);
        vehicles.add(bici1);

        String outputPath = "output.csv";
        try {
            FileWriter fileWriter = new FileWriter(outputPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write header line to the CSV file
            String header = "Brand,Production year,Color,Number of seats";
            bufferedWriter.write(header);
            bufferedWriter.newLine(); // Move to the next line
            for(Vehicle v : vehicles) {
                bufferedWriter.write(v.formatting());
                bufferedWriter.newLine();
            }

            // Close the BufferedWriter
            bufferedWriter.close();

            System.out.println("CSV file created successfully.");

        } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error occurred while writing to the CSV file.");
        }

        outputPath = "output.json";
        try {
            FileWriter fileWriter = new FileWriter(outputPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write header line to the CSV file
            for(Vehicle v : vehicles) {
                bufferedWriter.write(v.JSONFormat());
            }

            // Close the BufferedWriter
            bufferedWriter.close();

            System.out.println("JSON file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to the CSV file.");
        }
    }
}
