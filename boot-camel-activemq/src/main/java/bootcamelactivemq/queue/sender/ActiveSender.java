package bootcamelactivemq.queue.sender;

import bootcamelactivemq.queue.ActiveQueue;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ActiveSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:active-mq-timer?period=1000")
                .transform().constant(String.format("[Message: %s]", Instant.now()))
                .log("Enviando: ${body}")
                .to(String.format("activemq:%s", ActiveQueue.QUEUE.getQueue()));
    }
}
