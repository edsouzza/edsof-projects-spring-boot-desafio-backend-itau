package com.edsof.desafio_itau;

public record EstatisticaDTO(
        long count,
        Double avg,
        Double max,
        Double min,
        Double sum
) {
}
