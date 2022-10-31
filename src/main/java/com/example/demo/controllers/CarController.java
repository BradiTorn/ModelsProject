package com.example.demo.controllers;


import com.example.demo.models.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MarkaRepository markaRepository;

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    @GetMapping("/blog/carmain")
    public String carMain(Model model)
    {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "carmain";
    }

    @GetMapping("/blog/carmain/caradd")
    public String carAdd(Car car, Model model){
        model.addAttribute("markas", markaRepository.findAll());

        Iterable<Garage> garagess = garageRepository.findAll();
        model.addAttribute("garagess", garagess);
        return "caradd";
    }

    @GetMapping("/blog/carmain/markaadd")
    public String markaAdd( Model model){

        return "markaadd";
    }

    @GetMapping("/blog/carmain/garageadd")
    public String garageAdd(Garage garage, Model model){
        return "garageadd";
    }

    @PostMapping("/blog/carmain/garageadd")
    public Object garagePostAdd(@ModelAttribute("garage")@Validated Garage garage, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "garageadd";
        }
        garageRepository.save(garage);
        return "redirect:/";
    }



    @GetMapping("/blog/carmain/parkingadd")
    public String parkingAdd(Garage garage, Model model){
        return "parkingadd";
    }

    @PostMapping("/blog/carmain/parkingadd")
    public Object garagePostAdd(@ModelAttribute("parking")@Validated Parking parking, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "parkingadd";
        }
        parkingRepository.save(parking);
        return "redirect:/";
    }










    @PostMapping("/blog/carmain/caradd")
    public String blogPostAdd(@ModelAttribute("car")@Validated Car car, BindingResult bindingResult,
                              @RequestParam Long marka_id, Model model){
        model.addAttribute("markas", markaRepository.findAll());
        if(bindingResult.hasErrors()){
            return "caradd";
        }
        Marka marka;
        marka = markaRepository.findById(marka_id).get();
        car.setMarka(marka);
        carRepository.save(car);
        return "redirect:/";
    }

    @PostMapping("/blog/carmain/markaadd")
    public Object markaPostAdd(@ModelAttribute("marka")@Validated Marka marka, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "markaadd";
        }
        markaRepository.save(marka);
        return "redirect:/";
    }
















    @GetMapping("/blog/carmain/car-park")
    public String GetSU(Model model){
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        Iterable<Parking> parkings = parkingRepository.findAll();
        model.addAttribute("parkings", parkings);
        return "car-park";

    }


    @GetMapping("/blog/carmain/car-park/car-park-add")
    public String SUAdd(Car car, Parking parking, Model model){
        model.addAttribute("parkingss", parkingRepository.findAll());
        model.addAttribute("carss", carRepository.findAll());
        return "car-park-add";
    }

    @PostMapping("/blog/carmain/car-park/car-park-add")
    public String SUAdd(@RequestParam String cars, @RequestParam String parkings, Model model){
        Car car2 = carRepository.findByNamecarContains(cars);
        Parking parking2 = parkingRepository.findByRackContains(parkings);
        car2.getParkingList().add(parking2);
        parking2.getCarList().add(car2);
        carRepository.save(car2);
        parkingRepository.save(parking2);
        return "redirect:/blog/carmain/car-park";
    }
}
