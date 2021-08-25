package br.com.cvinicius.pattern.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SplitterConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("activemq:csv-files")
    		.to("log:csv-route-from-activemq");
        
    }
}
