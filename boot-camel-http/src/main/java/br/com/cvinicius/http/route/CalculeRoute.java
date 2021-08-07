package br.com.cvinicius.http.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CalculeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        final Random r = new Random();

        //Endereço da api
        restConfiguration().host("localhost").port(8080);

        from("timer:rest-calcule?period=10000")
                .setHeader("one", () ->  r.nextInt(1000))
                .setHeader("two", () -> r.nextInt(2000) )
                .log("Enviando os dados para calculo one[${header.one}] e two[${header.two}]")
                .to("rest:get:/calcule/sum/{one}/with/{two}")
                .log("${body}");
    }
}
