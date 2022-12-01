package vttp2022.ssf.ssfworkshop12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.ssfworkshop12.exception.RandomNumberException;
import vttp2022.ssf.ssfworkshop12.model.Generate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller


public class GenerateController {
    private Logger logger = LoggerFactory.getLogger(GenerateController.class);

    //root path
    //define our main page that forward to the generatePage(form)

    @GetMapping("/")
    public String showGenerateNumForm(Model model){
        logger.info("----showGenerateNumForm-----");
        //init an empty generate object that carries an int - x number to be gen
        Generate genObj = new Generate();
        //default to 1 everytime the page is loaded
        genObj.setNumberVal(1);
        // pass  it to the view as th:obj
        model.addAttribute("generateObj", genObj);
        return "generatePage";
    }

    @PostMapping("/generate")
    public String generateNumbers(@ModelAttribute Generate generate, Model model){
      String intStr = Integer.toString(generate.getNumberVal());
      this.generateRandomImages(intStr, model);
      return "generatePage";
       
        
    }

    @GetMapping("/generate")
    public String generateGetNumber(@RequestParam String numberVal, Model model){
        this.generateRandomImages(numberVal, model);
        return "generatePage";
    }

    @GetMapping("/generate/{numberVal}")
    public String generateGetNumberWifPathVar(@PathVariable String numberVal, Model model){
        this.generateRandomImages(numberVal, model);
        return "generatePage";
    }

    private void generateRandomImages(String generateNo, Model model){
        int genNo = 31;
        String[] imgNumbers = new String[genNo];
        int numberRandomNum = Integer.parseInt(generateNo);
        logger.info("from the text field > " + numberRandomNum);
        if(numberRandomNum > 30 || numberRandomNum < 1){
            throw new RandomNumberException();

        }
        for(int i = 0; i < genNo; i ++){
            imgNumbers[i] = "number" + i + ".jpg";
        }
        
        List<String> selectedImg = new ArrayList<String>();
        Random random = new Random();
        Set<Integer> uniqueGenResult = new LinkedHashSet<Integer>();
        while(uniqueGenResult.size()  < numberRandomNum){
            Integer resultRandNum = random.nextInt(genNo);
            uniqueGenResult.add(resultRandNum);

        }

        Iterator<Integer> it = uniqueGenResult.iterator();
        Integer currElm = null;
        while(it.hasNext()){
            currElm = it.next();
            selectedImg.add(imgNumbers[currElm.intValue()]);
            
        }
        Generate genObj = new Generate();
        genObj.setNumberVal(numberRandomNum);
        model.addAttribute("generateObj", genObj);
        model.addAttribute("randNoResult", selectedImg.toArray());
        model.addAttribute("numberRandomNum", numberRandomNum);


    }
}
