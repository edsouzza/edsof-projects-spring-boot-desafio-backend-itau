package com.edsof.desafio_itau;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    private final TransacaoService transacaoservice;

    @PostMapping
    public ResponseEntity <Void> adicionar(@RequestBody TransacaoRequest transacaorequest){
        transacaoservice.gravarDados(transacaorequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
