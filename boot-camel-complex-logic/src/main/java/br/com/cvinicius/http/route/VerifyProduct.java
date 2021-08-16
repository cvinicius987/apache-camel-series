package br.com.cvinicius.http.route;

import br.com.cvinicius.http.api.Response;
import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VerifyProduct {

    private static final Logger log = LoggerFactory.getLogger(VerifyProduct.class);

    public boolean condition(@Body Response body,
                             @Headers Map<String, String> map,
                             @ExchangeProperties Map<String, String> exchanges){

        log.info(" >>> Body [{}]", body);
        log.info(" >>> Headers [{}]", map);
        log.info(" >>> ExchangeProperties [{}]", exchanges);

        return body.getProduct().equalsIgnoreCase("Eletrônico");
    }
}
