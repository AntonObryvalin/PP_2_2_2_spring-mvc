package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> cars = carDao.getAllCars();
        // Если count задан, возвращаем ограниченное количество машин
        if (count != null && count > 0 && count < cars.size()) {
            return cars.subList(0, count);
        }
        return cars;  // Если count не задан или превышает количество машин, возвращаем все машины
    }
}
