package br.com.cvinicius.kafka.receiver;

import br.com.cvinicius.kafka.model.Order;
import br.com.cvinicius.kafka.model.Topics;
import br.com.cvinicius.kafka.model.UpdateDatabaseOrder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class XmlActiveReceiver extends RouteBuilder {

    private UpdateDatabaseOrder updateDatabaseOrder;

    public XmlActiveReceiver(UpdateDatabaseOrder updateDatabaseOrder){
        this.updateDatabaseOrder = updateDatabaseOrder;
    }

    @Override
    public void configure() throws Exception {

        from(String.format("kafka:%s", Topics.XML.getTopic()))
                .unmarshal().jacksonxml(Order.class)
                .log("Recebendo o pedido: ${body}")
                .bean(updateDatabaseOrder)
                .to("log:messages-xml-from-kafka");
    }
}

