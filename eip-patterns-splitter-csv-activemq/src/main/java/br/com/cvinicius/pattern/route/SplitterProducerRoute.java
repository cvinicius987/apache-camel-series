package br.com.cvinicius.pattern.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SplitterProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:files/csv")
                .convertBodyTo(String.class)
                .split(body(),",")
                .to("activemq:csv-files");
    }
}
