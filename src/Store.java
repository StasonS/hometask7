import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 17.09.17.
 */
public class Store {

    public List<Fruit> fruits = new ArrayList<>();
    public List<Client> clients = new ArrayList<>();
    public double moneyBalance = 0;

    /*
    метод принимает путь к файлу внутри которого находится json с фруктами и датой поставки.
    Один файл - одна поставка. Базу данных во время работы программы можно хранить в коллекции.
     */
    public void addFruits(String pathToJsonFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        fruits.addAll(JSON.parseArray(reader.readLine(), Fruit.class));
    }

    /*
    сохраняет всю информацию со склада лавки в json файл
     */
    public void save(String pathToJsonFile) throws IOException {

        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(JSON.toJSONString(this.fruits));
        writer.flush();
        writer.close();
    }

    /*
    удаляет текущую информацию из коллекции и загружает новую из сохраненной версии
     */
    public void load(String pathToJsonFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        fruits.clear();
        fruits.addAll(JSON.parseArray(reader.readLine(), Fruit.class));
    }

    //Solution 2

    /*
    Добавить к классу-лавке метод способный сказать какие продукты испортятся к заданной дате
     */
    public List<Fruit> getSpoiledFruits(Date date){
        List<Fruit> spoiled = new ArrayList<>();
        for (Fruit f : fruits){
            if ((new Date(f.deliveryDate.getTime() + f.shelfLife)).before(date)){
                spoiled.add(f);
            }
        }
        return spoiled;
    }

    /*
    метод который возвращает список готовых к продаже продуктов
     */
    public List<Fruit> getAvailableFruits(Date date){
        List<Fruit> available = new ArrayList<>();
        for (Fruit f : fruits){
            if ((new Date(f.deliveryDate.getTime() + f.shelfLife)).after(date)){
                available.add(f);
            }
        }
        return available;
    }

//    Solution 3

    public List<Fruit> getSpoiledFruits(Date date, Type type){

        List<Fruit> spoiled = new ArrayList<>();
        for (Fruit f : fruits){
            if ((new Date(f.deliveryDate.getTime() + f.shelfLife)).before(date)){
                if (f.type == type) {
                    spoiled.add(f);
                }
            }
        }
        return spoiled;
    }

    public List<Fruit> getAvailableFruits(Date date, Type type){
        List<Fruit> available = new ArrayList<>();
        for (Fruit f : fruits){
            if ((new Date(f.deliveryDate.getTime() + f.shelfLife)).after(date)){
                if (f.type == type) {
                    available.add(f);
                }
            }
        }
        return available;
    }

//    метод который возвращает продукты которые были доставлены в заданную дату
    public List<Fruit> getAddedFruits(Date date){
        List<Fruit> list = new ArrayList<>();
        for (Fruit f : fruits){
            if (f.deliveryDate.getDate() == date.getDate()){
                list.add(f);
            }
        }
        return list;
    }

    public List<Fruit> getAddedFruits(Date date, Type type){
        List<Fruit> list = new ArrayList<>();
        for (Fruit f : fruits){
            if (f.deliveryDate.getDate() == date.getDate() &&
                    f.type.equals(type)){
                list.add(f);
            }
        }
        return list;
    }

//    Solution 4

//    Метод принимает путь к файлу с джейсоном который хранит записи о клиентах
//    который хотели купить продукты в заданный день.

    public void sell(String pathToJsonFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        clients = JSON.parseArray(reader.readLine(), Client.class);
        for (Client c : clients){
            if ((countOfFruit(c.whatToBuy)) > c.count){
                fruitRemover(c.whatToBuy, c.count);
            }
            else {
                System.out.println("not enough " + c.whatToBuy);
            }
        }


    }

    public int countOfFruit(Type fruitType){
        int counter = 0;
        for (Fruit f : fruits){
            if (f.type.equals(fruitType)){
                counter++;
            }
        }
        return counter;
    }

    public void fruitRemover(Type fruitType, int count){
        if (countOfFruit(fruitType) > count){
            List<Fruit> tmp = new ArrayList<>();
            int i = 0;
            for (Fruit f : fruits){
                if (i < count){
                    if (f.type.equals(fruitType)){
                        moneyBalance += f.price;
                        i++;
                    }
                    else tmp.add(f);
                }
                else tmp.add(f);
            }
            fruits = tmp;
        }
    }
}
