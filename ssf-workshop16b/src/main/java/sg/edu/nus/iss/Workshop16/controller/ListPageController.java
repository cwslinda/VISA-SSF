package sg.edu.nus.iss.Workshop16.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ListPageController {
    private static final Logger logger = LoggerFactory.getLogger(ListPageController.class);
    
    @GetMapping("/")
    public String listAll() {
        return "list";
    }
}
