package br.com.cvinicius.kafka.sender;

import br.com.cvinicius.kafka.model.Order;
import br.com.cvinicius.kafka.model.Topics;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class XmlActiveSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:active-mq-timer-xml?period=1000")
                .transform().constant(new Order(UUID.randomUUID(), "DVD", BigDecimal.valueOf(255.58)))
                .marshal().jacksonxml()
                .log("Enviando XML: ${body}")
                .to(String.format("kafka:%s", Topics.XML.getTopic()));
    }
}
