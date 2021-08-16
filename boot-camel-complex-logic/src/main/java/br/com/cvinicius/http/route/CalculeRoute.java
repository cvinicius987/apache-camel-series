package br.com.cvinicius.http.route;

import br.com.cvinicius.http.api.Response;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CalculeRoute extends RouteBuilder {

    private final VerifyProduct verifyProduct;

    public CalculeRoute(VerifyProduct verifyProduct) {
        this.verifyProduct = verifyProduct;
    }

    @Override
    public void configure() throws Exception {

        final Random r = new Random();

        //Endereço da api
        restConfiguration().host("localhost").port(8080);

        from("timer:rest-calcule?period=1000")
                .setHeader("id", () ->  r.nextInt(1000))
                .log("Enviando o ID [${header.id}]")
                .to("rest:get:/product/{id}")
                .routeId("Http-Call")
                .unmarshal().json(JsonLibrary.Jackson, Response.class)
                .choice()
                    .when(method(verifyProduct))
                        .log(" >>> Produto do tipo: [${body.product}]")
                    .otherwise()
                        .log(" >>> Produto é indefinido")
                .end();
    }
}
