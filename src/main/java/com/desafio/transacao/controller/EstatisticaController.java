package com.desafio.transacao.controller;

import com.desafio.transacao.entity.Estatistica;
import com.desafio.transacao.service.EstatisticaService;
import com.desafio.transacao.service.TransacaoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;
    private final TransacaoServiceImpl transacaoService;

    public EstatisticaController(EstatisticaService estatisticaService, TransacaoServiceImpl transacaoService) {
        this.estatisticaService = estatisticaService;
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<Estatistica> consultaEstatistica(){

        return ResponseEntity.ok(estatisticaService
                .gerarEstatistica(transacaoService.consultar()));
    }
}
