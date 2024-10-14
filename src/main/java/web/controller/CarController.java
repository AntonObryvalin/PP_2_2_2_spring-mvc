package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService; // Сервис для работы с автомобилями

    // Инъекция CarService через конструктор
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = carService.getCars(count); // Получаем список машин из сервиса
        model.addAttribute("cars", cars); // Добавляем список машин в модель
        return "cars"; // Возвращаем имя представления
    }

}
