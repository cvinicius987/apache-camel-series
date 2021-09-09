package br.com.cvinicius.pattern.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RoutingSlipConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:endpoint1")
                .to("log:directendpoint1");

        from("direct:endpoint2")
                .to("log:directendpoint2");

        from("direct:endpoint3")
                .to("log:directendpoint3");
    }
}
