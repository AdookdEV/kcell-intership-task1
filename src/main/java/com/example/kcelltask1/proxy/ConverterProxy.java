package com.example.kcelltask1.proxy;

import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "converter",
        url="${converter.api.baseurl}")
public interface ConverterProxy {

    @GetMapping("/data/price")
    Map<String, Object> getPrice(@NotNull @RequestParam String fsym,
                                 @NotNull @RequestParam String tsyms);

    @GetMapping("/data/pricemulti")
    Map<String, Object> getMultiplePrice(@NotNull @RequestParam String fsyms,
                                         @NotNull @RequestParam String tsyms);
}
