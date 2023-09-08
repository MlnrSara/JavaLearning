import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Operation {

    public static long dailySales(LocalDate date, ArrayList<Sale> sales){
        return sales.stream().filter(s-> s.getDate().isEqual(date)).count();
    }


    public static long hourlySales(LocalDate date, LocalTime time, ArrayList<Sale> sales){
        return sales.stream().filter(s->s.getDate().isEqual(date) && s.getTime().getHour() == time.getHour()).count();
    }

    public static double totalIncome(ArrayList<Sale> sales){
        return sales.stream().map(s->s.getPrice()*s.getQuantity()).reduce(0.0,Double::sum);
    }

    public static String mostPopular(ArrayList<Sale> sales){
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
    public static boolean obsLength(Sale sale){
        return sale.getObs().length() <= 255;
    }
}
