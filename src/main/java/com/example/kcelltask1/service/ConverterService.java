package com.example.kcelltask1.service;

import com.example.kcelltask1.exception.InvalidParamsException;
import com.example.kcelltask1.proxy.ConverterProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConverterService {
    private final ConverterProxy converterProxy;

    public Map<String, Double> convertSingle(Double amount, String from, String to) {
        Map<String, Object> response = converterProxy.getPrice(from, to);
        if (response.containsValue("Error")) {
            throw new InvalidParamsException(response.get("Message").toString());
        }
        Map<String, Double> res = new HashMap<>();
        res.put(from, amount);
        for (String t : to.split(",")) {
            if (!response.containsKey(t.trim())) continue;
            res.put(t, amount * Double.parseDouble(response.get(t.trim()).toString()) );
        }
        return res;
    }

    public Map<String, Object> getExchangePrice(String from, String to) {
        return converterProxy.getMultiplePrice(from, to);
    }
}
