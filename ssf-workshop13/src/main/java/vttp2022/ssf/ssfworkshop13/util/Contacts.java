package vttp2022.ssf.ssfworkshop13.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import vttp2022.ssf.ssfworkshop13.models.Contact;
@Component("contacts")
public class Contacts {
    private static final Logger logger = LoggerFactory.getLogger(Contacts.class);


    public void saveContact(Contact ctc, Model model, ApplicationArguments appArgs, String defaultDataDir){
        // get ID save it as a variable and use it as file name
        String dataFileName = ctc.getId();
        PrintWriter prntWriter = null;
        try {
            // have to write something to this directory and write to this file name
            FileWriter fileWriter =  new FileWriter(getDataDir(appArgs, defaultDataDir) + "/" + dataFileName);
            //writing to this file
            prntWriter  = new PrintWriter(fileWriter);
            // println for individal line
            prntWriter.println(ctc.getName());
            prntWriter.println(ctc.getEmail());
            prntWriter.println(ctc.getPhoneNumber());
            prntWriter.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } 

        // sending back whatever is captured on the page
        // transport it out to another page
        // this key contact holds all the values 
        model.addAttribute("contact",  new Contact(ctc.getId(), ctc.getName(), 
                            ctc.getEmail(), ctc.getPhoneNumber()));
        
                            logger.info("ID Saved > " + ctc.getId());
    }

    public void getContactById(Model model, String contactId, ApplicationArguments appArgs, String defaultDataDir){
        Contact ctc = new Contact();
        try {
            // look for the path and form the fully qualified path in the object 
            Path filePath = new File(getDataDir(appArgs, defaultDataDir) + "/" +  contactId).toPath();
            Charset charset = Charset.forName("UTF-8");
            // readAlllines  method required the path
            List<String> stringList = Files.readAllLines(filePath, charset);
            ctc.setId(contactId);
            ctc.setName(stringList.get(0));
            ctc.setEmail(stringList.get(1));
            ctc.setPhoneNumber(Integer.parseInt(stringList.get(2)));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact info not found");
        }
        //transport the data back to the page show contact
        model.addAttribute("contact", ctc);
    }

    private String getDataDir(ApplicationArguments appArgs, String defaultDataDir){
        String dataDirResult = "";
        List<String> optValues = null;
        String[] optValuesArr = null;
        Set<String> opsNames = appArgs.getOptionNames();
        String[] optNamesArr = opsNames.toArray(new String[opsNames.size()]);
        if(optNamesArr.length > 0){
            optValues = appArgs.getOptionValues(optNamesArr[0]);
            optValuesArr = optValues.toArray(new String[optValues.size()]);
            dataDirResult = optValuesArr[0];
        } else {
            dataDirResult = defaultDataDir;
        }
            return dataDirResult;
    }

}
