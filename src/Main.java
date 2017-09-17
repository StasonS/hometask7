import com.alibaba.fastjson.JSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 17.09.17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        test4();
    }

    public static void test1() throws IOException {
        Store shop = new Store();
        shop.addFruits("src/data/supply1.txt");
        shop.addFruits("src/data/supply2.txt");
        shop.addFruits("src/data/supply3.txt");
        shop.save("src/data/store.txt");

        Store shop1 = new Store();
        shop1.load("src/data/store.txt");

        for (Fruit f : shop1.fruits){
            System.out.println(f.type);
        }
    }
    public static void test2() throws InterruptedException {
        Store store = new Store();
        store.fruits.add(new Fruit(5000, new Date(), 10, Type.Apple));
        store.fruits.add(new Fruit(10000, new Date(), 10, Type.Cherry));
        store.fruits.add(new Fruit(20000, new Date(), 10, Type.Peach));

        System.out.println("Waiting 11 sec");
        Thread.sleep(11000);
        Date d = new Date();

        System.out.println("List of spoiled fruits:");
        for (Fruit f : store.getSpoiledFruits(d)){
            System.out.println(f.type);
        }

        System.out.println("List of good fruits:");
        for (Fruit f : store.getAvailableFruits(d)){
            System.out.println(f.type);
        }
    }
    public static void test3() throws InterruptedException {
        Store store = new Store();
        store.fruits.add(new Fruit(5000, new Date(), 10, Type.Apple));
        store.fruits.add(new Fruit(10000, new Date(), 10, Type.Cherry));
        store.fruits.add(new Fruit(20000, new Date(), 10, Type.Peach));

        System.out.println("Waiting 11 sec");
        Thread.sleep(11000);
        Date d = new Date();

        System.out.println("\nNew spoiled - Apples");
        for (Fruit f : store.getSpoiledFruits(d, Type.Apple)){
            System.out.println(f.type);
        }
        System.out.println("\nNew good - Cherries");
        for (Fruit f : store.getAvailableFruits(d, Type.Cherry)){
            System.out.println(f.type);
        }
    }

    public static void test4() throws IOException {
        Store store = new Store();
//        List<Client> clients1 = new ArrayList<>();
//
//        Client c = new Client("Billy", Type.Apple, 2);
//        clients1.add(c);
//        clients1.add(new Client("Bob", Type.Apple, 2));
//        clients1.add(new Client("Bella", Type.Cherry, 1));
//        clients1.add(new Client("Sem", Type.Peach, 3));
//
        store.fruits.addAll(generateFruits(3, 4, 5, 6, 1,
                5, 7, 4, 8, 3));


//
//        FileWriter writer = new FileWriter("src/data/clients.txt");
//        writer.write(JSON.toJSONString(clients1));
//        writer.flush();
//        writer.close();

        System.out.println(store.countOfFruit(Type.Apple));
        String s = "" + store.countOfFruit(Type.Banana);
        System.out.println(s);

        store.sell("src/data/clients.txt");
        System.out.println(store.moneyBalance);


        System.out.println("Apples remain " + store.countOfFruit(Type.Apple));
        System.out.println("Cherries remain " + store.countOfFruit(Type.Cherry));
        System.out.println("Bananas remain " + store.countOfFruit(Type.Banana));
        System.out.println("Grapes remain " + store.countOfFruit(Type.Grape));

    }
    public static void test5(){}

    public static ArrayList<Fruit> generateFruits(int apples, int oranges, int cherries, int strawberries,
                                      int watermelons, int lemons, int pears, int peaches,
                                      int bananas, int grapes){
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < apples; i++){
            fruits.add(new Fruit(5000, new Date(), 20, Type.Apple));
        }
        for (int i = 0; i < oranges; i++){
            fruits.add(new Fruit(4000, new Date(), 25, Type.Orange));
        }
        for (int i = 0; i < cherries; i++){
            fruits.add(new Fruit(3000, new Date(), 15, Type.Cherry));
        }
        for (int i = 0; i < strawberries; i++){
            fruits.add(new Fruit(4500, new Date(), 22, Type.Strawberry));
        }
        for (int i = 0; i < watermelons; i++){
            fruits.add(new Fruit(5000, new Date(), 45, Type.Watermelon));
        }
        for (int i = 0; i < lemons; i++){
            fruits.add(new Fruit(10000, new Date(), 23, Type.Lemon));
        }
        for (int i = 0; i < pears; i++){
            fruits.add(new Fruit(2000, new Date(), 25, Type.Pear));
        }
        for (int i = 0; i < peaches; i++){
            fruits.add(new Fruit(5000, new Date(), 35, Type.Peach));
        }
        for (int i = 0; i < bananas; i++){
            fruits.add(new Fruit(15000, new Date(), 44, Type.Banana));
        }
        for (int i = 0; i < grapes; i++){
            fruits.add(new Fruit(5000, new Date(), 29, Type.Grape));
        }
        return fruits;
    }
}
