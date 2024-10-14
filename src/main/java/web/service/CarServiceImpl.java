package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> listCars = new ArrayList<>(); // // Список автомобилей

    // Инициализация списка из 5 машин
    public CarServiceImpl() {
        listCars.add(new Car(1, "Red", "AUDI"));
        listCars.add(new Car(2, "Blue", "BMW"));
        listCars.add(new Car(3, "Yellow", "LADA"));
        listCars.add(new Car(4, "Green", "VOLVO"));
        listCars.add(new Car(5, "Purple", "KIA"));
    }


    @Override
    public List<Car> getCars(Integer count) {
        if(count == null || count >= listCars.size() ){
            return listCars;
        }
        return listCars.subList(0,count);
    }
}
