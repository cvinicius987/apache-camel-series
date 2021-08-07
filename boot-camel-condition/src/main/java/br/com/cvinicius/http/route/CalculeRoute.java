package br.com.cvinicius.http.route;

import br.com.cvinicius.http.api.Response;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CalculeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        final Random r = new Random();

        //Endereço da api
        restConfiguration().host("localhost").port(8080);

        from("timer:rest-calcule?period=1000")
                .setHeader("one", () ->  r.nextInt(10))
                .setHeader("two", () -> r.nextInt(10) )
                .log("Enviando os dados para calculo one[${header.one}] e two[${header.two}]")
                .to("rest:get:/calcule/sum/{one}/with/{two}")
                .routeId("Http-Call")
                .unmarshal().json(JsonLibrary.Jackson, Response.class)
                .choice()
                    .when(simple("${body.result} > 10"))
                        .log(" >>> [${body.result}] é MAIOR que 10")
                    .otherwise()
                        .log(" >>> [${body.result}] é MENOR que 10")
                .end();
    }
}
