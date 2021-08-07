package br.com.cvinicius.http.api;

public class Response {

    private int result;
    private String msg;

    public Response(int result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
