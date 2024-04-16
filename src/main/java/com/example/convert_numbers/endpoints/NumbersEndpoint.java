package com.example.convert_numbers.endpoints;

import com.example.convert_numbers.ConvertToString;
import io.spring.guides.gs_producing_web_service.NumberToWords;
import io.spring.guides.gs_producing_web_service.NumberToWordsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class NumbersEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NumberToWords")
    @ResponsePayload
    public NumberToWordsResponse numberToWords(@RequestPayload NumberToWords request) {
        NumberToWordsResponse response = new NumberToWordsResponse();
        ConvertToString convertToString = new ConvertToString();
        response.setNumberToWordsResult(convertToString.convertToString(request.getUbiNum()));
        return response;
    }

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "numberToDollar")
//    @ResponsePayload
//    public NumberToDollarsResponse numberToDollar(@RequestPayload NumberToWords request) {
//        NumberToDollarsResponse response = new NumberToDollarsResponse();
//        ConvertToString convertToString = new ConvertToString();
//        response.setNumberToDollarsResult(convertToString.convertToString(request.getUbiNum()));
//        return response;
//    }

}
