package bootcamelactivemq.queue.sender;

import bootcamelactivemq.queue.ActiveQueue;
import bootcamelactivemq.queue.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ActiveSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:active-mq-timer?period=1000")
                .transform().constant(new Order(UUID.randomUUID(), "TV", LocalDateTime.now(), BigDecimal.valueOf(1225.50)))
                .marshal().json(JsonLibrary.Jackson)
                .log("Enviando: ${body}")
                .to(String.format("activemq:%s", ActiveQueue.QUEUE.getQueue()));
    }
}
