import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Singleton {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;
    private Singleton(){};
    private static class Helper{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Helper.instance;
    }
}
