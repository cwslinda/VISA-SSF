package vttp2022.ssf.ssfworkshop17b.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.ssfworkshop17b.model.Converter;
import vttp2022.ssf.ssfworkshop17b.service.ConverterService;

@Controller
@RequestMapping(path = "/convert")
public class ConverterController {
    
    @Autowired
    private ConverterService service;

    @GetMapping
    public String getInformation(@RequestParam (required = true) String amount, 
                                @RequestParam (required = true) String fromCountry, 
                                @RequestParam (required = true) String toCountry, 
                                 Model model){
        Optional<Converter> opt = service.getInformation(amount, fromCountry, toCountry);
        if(opt.isEmpty())
            return "convert";
        
        model.addAttribute("converter", opt.get());
        return "convert";
    }

}
