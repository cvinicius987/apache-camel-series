package br.com.cvinicius.kafka.sender;

import br.com.cvinicius.kafka.model.Order;
import br.com.cvinicius.kafka.model.Topics;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class JsonActiveSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:active-mq-timer?period=1000")
                .setBody(constant(new Order(UUID.randomUUID(), "TV", BigDecimal.valueOf(1225.50))))
                .marshal().json(JsonLibrary.Jackson)
                .log("Enviando JSON: ${body}")
                .to(String.format("kafka:%s", Topics.JSON.getTopic()));
    }
}
