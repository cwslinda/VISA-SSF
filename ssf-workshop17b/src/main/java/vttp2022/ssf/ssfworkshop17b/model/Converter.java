package vttp2022.ssf.ssfworkshop17b.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Converter{
    private static final Logger logger = LoggerFactory.getLogger(Converter.class);
    private String amount;
    private String fromCountry;
    private String toCountry;
    private String result;

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getFromCountry() {
        return fromCountry;
    }
    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }
    public String getToCountry() {
        return toCountry;
    }
    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public static Converter create(String json, String toCountry) throws IOException {

  
        Converter c = new Converter();

        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader reader = Json.createReader(is);
            JsonObject obj = reader.readObject();
            c.setAmount(obj.getJsonNumber("amount").toString());
            logger.info("amount >>> " + c.getAmount());
            JsonObject ratesObject = obj.getJsonObject("rates");
            logger.info("rates >>> " + ratesObject);
            c.toCountry = toCountry;
            logger.info("toCountry >>> " + c.getToCountry());
            c.fromCountry = obj.get("base").toString().replaceAll("\"", "");
            logger.info("from country >>>" + c.getFromCountry());
            c.result = ratesObject.get(toCountry).toString();
            logger.info("result >>> " + c.getResult());
        }

        return c;
    }
}
