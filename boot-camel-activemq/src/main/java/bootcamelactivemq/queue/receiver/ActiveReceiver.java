package bootcamelactivemq.queue.receiver;

import bootcamelactivemq.queue.ActiveQueue;
import bootcamelactivemq.queue.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveReceiver extends RouteBuilder {

    @Autowired
    private UpdateDatabaseOrder updateDatabaseOrder;

    @Override
    public void configure() throws Exception {

        from(String.format("activemq:%s", ActiveQueue.QUEUE.getQueue()))
                .unmarshal().json(JsonLibrary.Jackson, Order.class)
                .log("Recebendo o pedido: ${body}")
                .bean(new UpdateDatabaseOrder())
                .to("log:messages-from-activemq");
    }
}

