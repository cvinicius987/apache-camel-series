package br.com.cvinicius.activemq.receiver;

import br.com.cvinicius.activemq.model.Queues;
import br.com.cvinicius.activemq.model.Order;
import br.com.cvinicius.activemq.model.UpdateDatabaseOrder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class JsonActiveReceiver extends RouteBuilder {

    private UpdateDatabaseOrder updateDatabaseOrder;

    public JsonActiveReceiver(UpdateDatabaseOrder updateDatabaseOrder){
        this.updateDatabaseOrder = updateDatabaseOrder;
    }

    @Override
    public void configure() throws Exception {

        from(String.format("activemq:%s", Queues.JSON.getQueue()))
                .unmarshal().json(JsonLibrary.Jackson, Order.class)
                .log("Recebendo o pedido: ${body}")
                .bean(updateDatabaseOrder)
                .to("log:messages-from-activemq");
    }
}

