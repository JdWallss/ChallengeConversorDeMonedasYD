package com.AluraChallenges.ConversorDeMonedas.Models;
import java.util.HashMap;
import java.util.Map;

public record Moneda(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {
    public String toString() {
        return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
