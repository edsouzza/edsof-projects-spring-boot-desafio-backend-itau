package com.edsof.desafio_itau;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransacaoService {
    private List<Object> listaDados = new ArrayList<>();

    private boolean verificarDados(TransacaoRequest transacaorequest){
        BigDecimal valor        = transacaorequest.getValor();
        OffsetDateTime dataHora = transacaorequest.getDataHora();

        if (valor == null || dataHora == null) {
            log.info("Valor ou data nao podem ser nulos");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Valor ou data nao podem ser nulos");
        }

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            log.info("Valor nao pode ser negativo");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Valor nao pode ser negativo");
        }

        if (dataHora.isAfter(OffsetDateTime.now())) {
            log.info("Data/hora nao pode ser no futuro");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Data/hora nao pode ser no futuro");
        }
        return true;
    }

    public void gravarDados(TransacaoRequest transacaorequest){
        if(!verificarDados(transacaorequest)){
            throw new TransacaoException("A transacao nao foi aceita: valor negativo ou data invalida");
        }
        listaDados.add(transacaorequest.getValor());
        listaDados.add(transacaorequest.getDataHora());
        mostrarDados();
    }

    public void mostrarDados(){
        for(Object dados : listaDados){
            System.out.println(dados);
        }
    }


}
