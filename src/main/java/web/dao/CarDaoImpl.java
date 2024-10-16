package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final List<Car> listCars = new ArrayList<>(); // // Список автомобилей

    // Инициализация списка из 5 машин
    {
        listCars.add(new Car(1, "Red", "AUDI"));
        listCars.add(new Car(2, "Blue", "BMW"));
        listCars.add(new Car(3, "Yellow", "LADA"));
        listCars.add(new Car(4, "Green", "VOLVO"));
        listCars.add(new Car(5, "Purple", "KIA"));
    }

    @Override
    public List<Car> getAllCars() {
        return listCars;
    }
}
