package br.com.cvinicius.http.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorApi {

    @GetMapping("/calcule/sum/{one}/with/{two}")
    public Response calcule(@PathVariable int one,
                            @PathVariable  int two){

        var result = one + two;

        return new Response(result, "Operação de Soma");
    }
}
