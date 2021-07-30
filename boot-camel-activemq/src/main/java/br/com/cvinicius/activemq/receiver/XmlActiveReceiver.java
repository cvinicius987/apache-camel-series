package br.com.cvinicius.activemq.receiver;

import br.com.cvinicius.activemq.model.Queues;
import br.com.cvinicius.activemq.model.Order;
import br.com.cvinicius.activemq.model.UpdateDatabaseOrder;
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

        from(String.format("activemq:%s", Queues.XML.getQueue()))
                .unmarshal().jacksonxml(Order.class)
                .log("Recebendo o pedido: ${body}")
                .bean(updateDatabaseOrder)
                .to("log:messages-xml-from-activemq");
    }
}

