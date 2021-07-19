package simpleroute;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class SimpleRoute extends RouteBuilder {

    public void configure()
            throws Exception {

        from("timer:first-timer")
                .log("${body}") //Log do body
                .transform()
                    .constant("My Constant Message") //Seta uma constante no valor
                .log("${body}") //Log do body
                .bean(new TransformBean()) //Transformação
                .log("${body}")
                .bean(new Logging())
                .to("log:first-timer");
    }
}

class TransformBean {

    public String getCurrentTime() {
        return String.format("Transformação em [%s]", LocalDateTime.now());
    }
}

class Logging {

    private Logger logger = LoggerFactory.getLogger(Logging.class);

    public void process(String message) {

        logger.info("Logger {}", message);
    }
}
