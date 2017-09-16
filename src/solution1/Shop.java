package solution1;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.09.17.
 */
public class Shop {

    List<Fruit> fruits = new ArrayList<>();

    /*
    метод принимает путь к файлу внутри которого находится json с фруктами и датой поставки.
    Один файл - одна поставка. Базу данных во время работы программы можно хранить в коллекции.
     */
    void addFruits(String pathToJsonFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        fruits.addAll(JSON.parseArray(reader.readLine(), Fruit.class));
    }

    /*
    сохраняет всю информацию со склада лавки в json файл
     */
    void save(String pathToJsonFile) throws IOException {

        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(JSON.toJSONString(this.fruits));
        writer.flush();
        writer.close();
    }

    /*
    удаляет текущую информацию из коллекции и загружает новую из сохраненной версии
     */
    void load(String pathToJsonFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        fruits.clear();
        fruits.addAll(JSON.parseArray(reader.readLine(), Fruit.class));
    }
}
