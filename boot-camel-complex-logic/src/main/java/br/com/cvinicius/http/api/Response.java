package br.com.cvinicius.http.api;

public class Response {

    private String product;

    public Response(){}

    public Response(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Response{" +
                "product='" + product + '\'' +
                '}';
    }
}
