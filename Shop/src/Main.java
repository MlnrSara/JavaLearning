import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static ArrayList<Sale> validateLines() throws IOException { //chestia cu throws mi-o sugerat-o editorul, nu intreba
        File inputFile = new File("C:\\Users\\sara.molnar\\OneDrive - ACCESA\\Documents\\input.csv");
        ArrayList<String> validInfo = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String currentLine;
        currentLine = reader.readLine();
        validInfo.add(currentLine);
        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            String[] infoSeparated = trimmedLine.split(";");
            Sale tempSale = new Sale(infoSeparated);
            if (tempSale.getStatus().equals("anulat")) continue;
            validInfo.add(currentLine);
        }
        reader.close();
        FileWriter input = new FileWriter(inputFile);
        BufferedWriter writer = new BufferedWriter(input);
        PrintWriter fileWriter = new PrintWriter(writer);
        for (String info: validInfo){
            fileWriter.println(info);
        }
        fileWriter.close();
        writer.close();
        ArrayList<Sale> sales = new ArrayList<Sale>();
        for(int i=1; i<validInfo.size(); i++){
            String[] infoSeparated = validInfo.get(i).split(";");
            Sale sale = new Sale(infoSeparated);
            sales.add(sale);
        }
        return sales;
    }

    public static void addSaleInFile(String input) throws IOException {
        FileWriter inputFile = new FileWriter("C:\\Users\\sara.molnar\\OneDrive - ACCESA\\Documents\\input.csv", true);
        BufferedWriter writer = new BufferedWriter(inputFile);
        PrintWriter fileWriter = new PrintWriter(writer);
        fileWriter.println(input);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Sale> sales = Main.validateLines();
        Main.addSaleInFile("7;2023-03-23;12:23:35;5.00;Servetele de buzunar;2;Bucuresti;Oradea;livrat;sa nu le sifonati");
        for(Sale sale: sales){
            System.out.println(sale);
        }
        System.out.println("Number of sales : " + Operation.dailySales(LocalDate.of(2023, 9, 7),sales));
        System.out.println("Number of sales today at 9: " + Operation.hourlySales(LocalDate.of(2023, 9, 7), LocalTime.of(9,0),sales));
        System.out.println("Total income: " + Operation.totalIncome(sales));
        System.out.println("Most popular: " + Operation.mostPopular(sales));
        System.out.println("The IDs are different: " + Operation.checkUniqueID(sales));
    }
}