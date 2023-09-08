import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Sale {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private double price;
    private String itemName;
    private int quantity;
    private String destination;
    private String location;
    private String status;
    private String obs;

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDestination() {
        return destination;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getObs() {
        return obs;
    }

    public Sale(){
        id = 0;
        date = LocalDate.now();
        time = LocalTime.now();
        price = 0;
        itemName = "";
        quantity = 0;
        destination = "";
        location = "";
        status = "";
        obs = "";
    }
    public Sale(int id, LocalTime time, LocalDate date, double price, String item, int quantity, String destination, String location, String status, String obs){
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.itemName = item;
        this.quantity = quantity;
        this.destination = destination;
        this.location = location;
        this.status = status;
        this.obs = obs;
    }
    public Sale(String[] info){
        this.id = Integer.parseInt(info[0]);
        this.date = LocalDate.parse(info[1]);
        this.time = LocalTime.parse(info[2]);
        this.price = Double.parseDouble(info[3]);
        this.itemName = info[4];
        this.quantity = Integer.parseInt(info[5]);
        this.destination = info[6];
        this.location = info[7];
        this.status = info[8];
        this.obs = info[9];
    }

    @Override
    public String toString() {
        String message = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String rightTime = this.time.format(formatter);
        message += this.id + "  Date: " + date + " Time: "+ rightTime + "  Item: " + itemName + "  Price: " + price;
        return message;
    }
}
