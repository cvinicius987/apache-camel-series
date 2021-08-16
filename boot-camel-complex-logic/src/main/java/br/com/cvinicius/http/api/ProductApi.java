package br.com.cvinicius.http.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApi {

    @GetMapping("/product/{id}")
    public Response view(@PathVariable Integer id){

        String result;

        if( (id % 2) == 0){
            result= "Eletrônico";
        }
        else{
            result = "Indefinido...................";
        }

        return new Response(result);
    }
}
