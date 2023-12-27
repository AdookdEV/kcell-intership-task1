package com.example.kcelltask1.controller;

import com.example.kcelltask1.service.ConverterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name="Controller for working with currency", description="This controller is responsible for getting exchange rate for currencies")
public class CurrencyController {
    private final ConverterService converterService;

    @Operation(
            summary = "Converting from one currency to another with specified amount of money(default 1)"
    )
    @GetMapping("/api/currency/convert")
    public ResponseEntity<Map<String, Double>> convertSingleValue(
            @Parameter(description = "Amount of money to convert.")
            @Positive @RequestParam(defaultValue = "1", required = false)
            Double amount,

            @Parameter(description = "The source currency symbol ")
            @NotNull @RequestParam String from,

            @Parameter(description = "The target currency symbol(s) to which the conversion is desired.")
            @NotNull @RequestParam String to) {

        return ResponseEntity.ok(converterService.convertSingle(amount, from, to));
    }

    @Operation(
            summary = "Getting exchange price for currencies"
    )
    @GetMapping("/api/currency/exchange")
    public ResponseEntity<Map<String, Object>> getExchange(
            @Parameter(description = "The source currency symbols for which exchange rates are needed")
            @NotNull @RequestParam String from,

            @Parameter(description = "The target currency code to which exchange rates are needed.")
            @NotNull @RequestParam String to) {
        return ResponseEntity.ok(converterService.getExchangePrice(from, to));
    }
}
