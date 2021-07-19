package bootcamelfiles;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

    private static final String INPUT = "files/input";
    private static final String OUTPUT = "files/output";

    @Override
    public void configure()
            throws Exception {

        from("file:"+INPUT)
                .log("${body}")
                .to("file:"+OUTPUT);
    }
}
