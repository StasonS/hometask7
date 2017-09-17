import java.util.Date;

/**
 * Created by user on 17.09.17.
 */
public class Fruit {
    public long shelfLife;
    public Date deliveryDate;
    public double price;
    public Type type;

    public Fruit(long shelfLife, Date deliveryDate, double price, Type type) {
        this.shelfLife = shelfLife;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.type = type;
    }
}
