package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao cardao;

    @Override
    public List<Car> getCars(int count) {

        if (count == 0 || count >= 5) {
            return cardao.getCars();
        }

        return cardao.getCars().stream().limit(count).collect(Collectors.toList());

    }
}
