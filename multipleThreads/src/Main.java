import java.io.*;
import java.util.Scanner;

public class Main implements Runnable{

    private String fileName;

    public void run() {
        try {
            FileWriter file = new FileWriter(this.fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("I am writing in " + this.fileName);
            printWriter.close();
            bufferedWriter.close();
            file.close();
        } catch (IOException e){
            System.out.println("The file did not open correctly.");
        }
    }

    public Main(String fileName) {
        this.fileName = fileName;
    }


    public static void main(String[] args) {
        Runnable firstThread = new Main("first.txt");
        Thread first = new Thread(firstThread);
        Runnable secondThread = new Main("second.txt");
        Thread second = new Thread(secondThread);
        Runnable thirdThread = new Main("third.txt");
        Thread third = new Thread(thirdThread);
        Runnable forthThread = new Main("forth.txt");
        Thread forth = new Thread(forthThread);
        Runnable fifthThread = new Main("fifth.txt");
        Thread fifth = new Thread(fifthThread);
        Runnable sixthThread = new Main("sixth.txt");
        Thread sixth = new Thread(sixthThread);
        Runnable seventhThread = new Main("seventh.txt");
        Thread seventh = new Thread(seventhThread);
        Runnable eighthThread = new Main("eighth.txt");
        Thread eighth = new Thread(eighthThread);
        Runnable ninthThread = new Main("ninth.txt");
        Thread ninth = new Thread(ninthThread);
        Runnable tenthThread = new Main("tenth.txt");
        Thread tenth = new Thread(tenthThread);

        Runnable printOne = new Waiter("first.txt");
        Thread firstPrint = new Thread(printOne);

        Runnable printTwo = new Waiter("second.txt");
        Thread secondPrint = new Thread(printTwo);

        Runnable printThree = new Waiter("third.txt");
        Thread thirdPrint = new Thread(printThree);

        Runnable printFour = new Waiter("forth.txt");
        Thread forthPrint = new Thread(printFour);

        Runnable printFive = new Waiter("fifth.txt");
        Thread fifthPrint = new Thread(printFive);

        Runnable printSix = new Waiter("sixth.txt");
        Thread sixthPrint = new Thread(printSix);

        Runnable printSeven = new Waiter("seventh.txt");
        Thread seventhPrint = new Thread(printSeven);

        Runnable printEight = new Waiter("eighth.txt");
        Thread eighthPrint = new Thread(printEight);

        Runnable printNine = new Waiter("ninth.txt");
        Thread ninthPrint = new Thread(printNine);

        Runnable printTen = new Waiter("tenth.txt");
        Thread tenthPrint = new Thread(printTen);

        first.start();
        second.start();
        third.start();
        forth.start();
        fifth.start();
        sixth.start();
        seventh.start();
        eighth.start();
        ninth.start();
        tenth.start();

        try {
            first.join();
            second.join();
            third.join();
            forth.join();
            fifth.join();
            sixth.join();
            seventh.join();
            eighth.join();
            ninth.join();
            tenth.join();

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        firstPrint.start();
        secondPrint.start();
        thirdPrint.start();
        forthPrint.start();
        fifthPrint.start();
        sixthPrint.start();
        seventhPrint.start();
        eighthPrint.start();
        ninthPrint.start();
        tenthPrint.start();


    }
}