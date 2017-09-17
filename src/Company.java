import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 17.09.17.
 */
public class Company {

    List<Store> stores = new ArrayList<>();
    double moneyBalance = 0;
    
//    сохраняет всю информацию компании
    void save(String pathToJsonFile) throws IOException {
        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(JSON.toJSONString(this));
        writer.flush();
        writer.close();
    }

//    загружает всю информацию компании
    void load(String pathToJsonFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        stores.clear();
        stores.addAll(JSON.parseArray(reader.readLine(), Store.class));
    }

//    геттер лавки по индексу из коллекции
    public Store getStore(int index){
        if (stores.size() >= index)
            return stores.get(index);
        else
            System.out.println("No such store");
        return null;
    }

//    возвращает сумму балансов всех лавок
    int getCompanyBalance(){
        int allMoney = 0;
        for (Store s : stores){
            allMoney += s.moneyBalance;
        }
        return allMoney;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getSpoiledFruits(Date date){
        List<Fruit> spoiled = new ArrayList<>();
        for (Store s : stores){
            spoiled.addAll(s.getSpoiledFruits(date));
        }
        return spoiled;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getAvailableFruits(Date date){
        List<Fruit> available = new ArrayList<>();
        for (Store s : stores){
            available.addAll(s.getAvailableFruits(date));
        }
        return available;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getAddedFruits(Date date){
        List<Fruit> added = new ArrayList<>();
        for (Store s : stores){
            added.addAll(s.getAddedFruits(date));
        }
        return added;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getSpoiledFruits(Date date, Type type){
        List<Fruit> spoiled = new ArrayList<>();
        for (Store s : stores){
            spoiled.addAll(s.getAddedFruits(date, type));
        }
        return spoiled;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getAvailableFruits(Date date, Type type){
        List<Fruit> available = new ArrayList<>();
        for (Store s : stores){
            available.addAll(s.getAvailableFruits(date, type));
        }
        return available;
    }

//    работает также, но в масштабах компании (по всем лавкам)
    List<Fruit> getAddedFruits(Date date, Type type){
        List<Fruit> added = new ArrayList<>();
        for (Store s : stores){
            added.addAll(s.getAddedFruits(date, type));
        }
        return added;
    }
}
