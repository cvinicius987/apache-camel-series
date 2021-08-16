package br.com.cvinicius.http.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MulticastRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //Endereço da api
        restConfiguration().host("localhost").port(8080);

        from("timer:multicast?period=5000")
                .multicast()
                .to("rest:get:/multicast", "log:teste-multicast");
    }
}
