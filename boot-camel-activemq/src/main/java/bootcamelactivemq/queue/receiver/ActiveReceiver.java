package bootcamelactivemq.queue.receiver;

import bootcamelactivemq.queue.ActiveQueue;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from(String.format("activemq:%s", ActiveQueue.QUEUE.getQueue()))
                .to("log:messages-from-activemq");
    }
}
