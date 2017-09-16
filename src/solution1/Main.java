package solution1;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * Created by user on 16.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Shop shop = new Shop();
        shop.addFruits("src/solution1/data/supply1.txt");
        shop.addFruits("src/solution1/data/supply2.txt");
        shop.addFruits("src/solution1/data/supply3.txt");
        shop.save("src/solution1/data/store.txt");

        Shop shop1 = new Shop();
        shop1.load("src/solution1/data/store.txt");
        
        for (Fruit f : shop1.fruits){
            System.out.println(f);
        }
    }
}
