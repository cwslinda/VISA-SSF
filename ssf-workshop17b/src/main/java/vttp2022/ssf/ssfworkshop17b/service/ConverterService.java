package vttp2022.ssf.ssfworkshop17b.service;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp2022.ssf.ssfworkshop17b.model.Converter;

@Service
public class ConverterService {
    private static final Logger logger = LoggerFactory.getLogger(ConverterService.class);
    private static String url = "https://api.frankfurter.app/latest";
    private static String url2 = "https://api.frankfurter.app/currencies";

    // @Value("${converter.key}")
    // private String apiKey;

    // private boolean hasKey;
    // @PostConstruct
    // private void init(){
    //     hasKey = null != apiKey;
    //     logger.info(">>> api key set : " +  hasKey);
    // }

    public Optional<Converter> getInformation(String amount, String fromCountry, String toCountry){
    
       
        String converterUrl = UriComponentsBuilder.fromUriString(url)
            .queryParam("amount", amount)
            .queryParam("from", fromCountry)
            .queryParam("to", toCountry)
            .toUriString();
            logger.info(" >>> complete converter uri api address " + converterUrl);

            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp = null;
            
            try {
                resp = template.getForEntity(converterUrl, String.class);
                Converter c = Converter.create(resp.getBody(), toCountry);
                logger.info("resp >>> " + resp.getBody());
                return Optional.of(c);
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }

            return Optional.empty();

    }
}


