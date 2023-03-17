package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;


import java.util.List;
import java.util.Optional;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", required = false) Optional<Integer> countCar, Model model){

        List<Car> cars = carService.getCars(countCar.orElse(0));

        model.addAttribute("cars", cars);

        return "cars";
    }

}
