package solution1;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Date;

/**
 * Created by user on 16.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Shop shop = new Shop();

        Fruit f1 = new Fruit(3000, new Date(), 10, Fruit.Type.Apple);
        Fruit f2 = new Fruit(4000, new Date(), 20, Fruit.Type.Banana);
        Fruit f3 = new Fruit(5000, new Date(), 30, Fruit.Type.Cherry);
        shop.fruits.add(f1);
        shop.fruits.add(f2);
        shop.fruits.add(f3);

        shop.save("src/solution1/data/supply1.txt");

        System.out.println(shop.fruits.get(0).type);
        System.out.println(JSON.toJSONString(shop.fruits));
    }
}
