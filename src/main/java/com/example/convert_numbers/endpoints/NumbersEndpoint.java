package com.example.convert_numbers.endpoints;

import com.example.convert_numbers.ConvertToString;
import io.spring.guides.gs_producing_web_service.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class NumbersEndpoint {

    private static final String NAMESPACE_URI = "Convert numbers";

    @Autowired
    public NumbersEndpoint(){}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "numberToWords")
    @ResponsePayload
    public NumberToWordsResponse numberToWord(BigInteger number) {
        NumberToWordsResponse response = new NumberToWordsResponse();
        ConvertToString convertToString = new ConvertToString();
        convertToString.setNumber(number);
        response.setNumberToWordsResult(convertToString.convertToString());
        return response;
    }

}
