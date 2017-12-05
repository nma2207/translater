package com.unikre.yandex.http;

import com.unikre.yandex.params.ApiVersion;
import com.unikre.yandex.params.RequestInterface;

import retrofit2.Response;

public abstract class YandexExecutor {


    protected String apiKey;


    protected ApiVersion apiVersion;


    protected RequestInterface requestInterface;

    protected YandexService yandexService;

    public YandexExecutor(String apiKey) {
        setApiKey(apiKey);
    }

    protected void validateResponse(Response response) throws Exception {
        // Result - status code
        ResponseCode responseCode = ResponseCode.byCode(response.code());
        if (responseCode == null) {
            throw new Exception("API call error: " + response.code() + " - " + response.message());
        } else if (responseCode.compareTo(ResponseCode.OK) != 0) {
            throw new Exception("API call error: " + responseCode.code + " - " + responseCode.description);
        }

        // Result - body
        if (response.body() == null) {
            throw new Exception("API call error: Empty response body");
        }
    }
    public void setApiKey(String key){
        apiKey=key;
    }
    public void setApiVersion(ApiVersion apiVersion){
        this.apiVersion=apiVersion;
    }
    public void setRequestInterface(RequestInterface requestInterface){
        this.requestInterface=requestInterface;
    }
    public ApiVersion getApiVersion(){
        return  apiVersion;
    }
    public RequestInterface getRequestInterface(){
        return requestInterface;
    }
    public String getApiKey(){
        return apiKey;
    }

}
