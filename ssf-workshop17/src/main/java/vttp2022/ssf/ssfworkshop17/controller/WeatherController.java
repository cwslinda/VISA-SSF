package vttp2022.ssf.ssfworkshop17.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.ssfworkshop17.models.Weather;
import vttp2022.ssf.ssfworkshop17.service.WeatherService;

@Controller
@RequestMapping(path = "/weather")
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService service;


    @GetMapping
    public String getWeather(@RequestParam (required = true) String city, Model model){
        Optional<Weather> opt = service.getWeather(city);
        if(opt.isEmpty())
         return "weather";
        
    model.addAttribute("weather", opt.get());
    return "weather";
    }
    
}
