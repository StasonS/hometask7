package solution1;

import java.util.Date;

/**
 * Created by user on 16.09.17.
 */
public class Fruit {

    long shelfLife;
    Date deliveryDate;
    double price;
    Type type;

    public Fruit(long shelfLife, Date deliveryDate, double price, Type type) {
        this.shelfLife = shelfLife;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.type = type;
    }

    enum Type{
        Apple, Orange, Cherry, Strawberry, Watermelon,
        Lemon, Pear, Peach, Banana, Grape
    }
}
