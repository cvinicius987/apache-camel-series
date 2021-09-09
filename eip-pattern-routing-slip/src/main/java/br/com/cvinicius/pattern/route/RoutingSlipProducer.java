package br.com.cvinicius.pattern.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RoutingSlipProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String routingSlip = "direct:endpoint1,direct:endpoint2,direct:endpoint3";

        from("timer:routingSlip?period=10000")
                .setBody(f -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .routingSlip(simple(routingSlip));
    }
}
