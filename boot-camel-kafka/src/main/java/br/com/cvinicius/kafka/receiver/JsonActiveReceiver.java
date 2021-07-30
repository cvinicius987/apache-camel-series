package br.com.cvinicius.kafka.receiver;

import br.com.cvinicius.kafka.model.Order;
import br.com.cvinicius.kafka.model.Topics;
import br.com.cvinicius.kafka.model.UpdateDatabaseOrder;
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

        from(String.format("kafka:%s", Topics.JSON.getTopic()))
                .unmarshal().json(JsonLibrary.Jackson, Order.class)
                .log("Recebendo o pedido: ${body}")
                .bean(updateDatabaseOrder)
                .to("log:messages-from-kafka");
    }
}

