package br.com.cvinicius.http.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MulticastApi {

    private final Logger log = LoggerFactory.getLogger(MulticastApi.class);

    @GetMapping("/multicast")
    public void view(){

        log.info(">>> Chamada ao MultiCastRequest.............");
    }
}
