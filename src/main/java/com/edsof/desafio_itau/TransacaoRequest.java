package com.edsof.desafio_itau;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
