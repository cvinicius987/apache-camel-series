package br.com.cvinicius.pattern.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RoutingSlipConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:endpoint1")
                .to("log:console1");

        from("direct:endpoint2")
                .to("log:console2");

        from("direct:endpoint3")
                .to("log:console3");
    }
}
