import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Operation {

    public static long getDailySales(LocalDate date, ArrayList<Sale> sales){
        return sales.stream().filter(s-> s.getDate().isEqual(date)).count();
    }


    public static long getHourlySales(LocalDate date, LocalTime time, ArrayList<Sale> sales){
        return sales.stream().filter(s->s.getDate().isEqual(date) && s.getTime().getHour() == time.getHour()).count();
    }

    public static double getTotalIncome(ArrayList<Sale> sales){
        List<Double> mappedSales = sales.stream().map(s->s.getPrice()*s.getQuantity()).collect(Collectors.toList());
        List<Double> temp = mappedSales.stream().filter(s->s<0).collect(Collectors.toList());
        try{
            if(!temp.isEmpty())
                throw new MyException("Why is there a negative price?!");
        } catch(MyException e) {
            System.out.println(e.getMessage());
        }
        return mappedSales.stream().reduce(0.0,Double::sum);
    }

    public static String getMostPopularItem(ArrayList<Sale> sales){
        List<String> mappedSales = sales.stream().map(s->s.getItemName()).collect(Collectors.toList());
        mappedSales = mappedSales.stream().sorted().collect(Collectors.toList());
        int count = 1;
        int max = 0;
        String mostPopular = "";
        for (int i = 0; i < mappedSales.size(); i++){
            if(i != mappedSales.size() - 1 && mappedSales.get(i).equals(mappedSales.get(i+1))) {
                count++;
                if (count > max) {
                    max = count;
                    mostPopular = mappedSales.get(i);
                }
                System.out.println("count for: " + mappedSales.get(i) + " " + count);
            } else
                count = 1;
        }
        return mostPopular;
    }

    public static boolean checkUniqueID(ArrayList<Sale> sales){
        List<Integer> intermediate = sales.stream().map(s->s.getId()).collect(Collectors.toList());
        List<Integer> distinctElements = intermediate.stream().distinct().collect(Collectors.toList());
        return sales.size() == distinctElements.size();
    }
    public static boolean checkObsLength(Sale sale){
        return sale.getObs().length() <= 255;
    }

}
