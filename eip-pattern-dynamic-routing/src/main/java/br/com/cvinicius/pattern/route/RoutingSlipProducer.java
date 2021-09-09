package br.com.cvinicius.pattern.route;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class RoutingSlipProducer extends RouteBuilder {

    private final LogicSendMessage logicSendMessage;

    public RoutingSlipProducer(LogicSendMessage logicSendMessage) {
        this.logicSendMessage = logicSendMessage;
    }

    @Override
    public void configure() throws Exception {

        var random = new Random();

        from("timer:routingSlip?period={{timeRouting}}")
                .setBody(f -> {
                    var temp = random.nextInt(100);

                    return temp;
                })
                .dynamicRouter(method(logicSendMessage));
    }
}

@Component
class LogicSendMessage {

    Logger logger = LoggerFactory.getLogger(LogicSendMessage.class);

    int invocations ;

    public String logicSendMessage(
            @ExchangeProperties Map<String, String> properties,
            @Headers Map<String, String> headers,
            @Body String body
    ) {
        logger.info("{} {} {}", properties, headers, body);

        invocations++;

        if(invocations%3==0)
            return "direct:endpoint1";

        if(invocations%3==1)
            return "direct:endpoint2,direct:endpoint3";

        return null;
    }
}


