import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Waiter implements Runnable{
    private String fileName;

    public Waiter( String fileName) {
        this.fileName = fileName;
    }

    public void run (){
        try {
            FileReader file = new FileReader(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
            file.close();
        } catch (IOException e){
            System.out.println("No file found.");
        }
    }
}
