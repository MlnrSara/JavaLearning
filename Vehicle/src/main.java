import Model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Automobil automobil = new Automobil("blue", "Toyota", 2020, 1000, true, "CJ05GHK", 5);
        Motorbike moto1 = new Motorbike("gray", "Yamaha", 1997, "B238FGC", 80, 1);
        Vehicle avi1 = new Plane();
        Bike bici1 = new Bike("red", "Pegasus", 2000, 1, 5);
        vehicles.add(automobil);
        vehicles.add(moto1);
        vehicles.add(avi1);
        vehicles.add(bici1);

        String outputPathCsvFile = "output.csv";
        try {
            FileWriter fileWriter = new FileWriter(outputPathCsvFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write header line to the CSV file
            try{
            String header = "Brand,Production year,Color,Number of seats";
            bufferedWriter.write(header);
            bufferedWriter.newLine(); // Move to the next line
                for (int i = 0; i < vehicles.size(); i++) {
                    bufferedWriter.write(vehicles.get(i).formating());
                    bufferedWriter.newLine();
                }
            } catch (Exception writingException){
                writingException.printStackTrace();
                System.out.println("Error occurred while writing to the CSV file. Exception: "+ writingException.getMessage());
            }
            finally {
                bufferedWriter.close();

            }
            // Close the BufferedWriter

            System.out.println("CSV file created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to the CSV file. Exception: "+ e.getMessage());
        }
        String outputPathJsonFile = "output.json";
        try {
            FileWriter fileWriter = new FileWriter(outputPathJsonFile);
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
