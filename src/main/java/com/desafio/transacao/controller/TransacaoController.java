package com.desafio.transacao.controller;

import com.desafio.transacao.entity.Transacao;
import com.desafio.transacao.service.TransacaoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoServiceImpl transacaoService;

    public TransacaoController(TransacaoServiceImpl transacaoService) {
        this.transacaoService = transacaoService;
    }
    @ApiOperation(value = "Cadastra uma nova transação")
    @PostMapping
    public ResponseEntity<Void> cadastrarTransacao(@RequestBody @Valid Transacao transacao) {
        try {
            transacaoService.salvar(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Consulta a lista de transações")
    @GetMapping
    public ResponseEntity<List<Transacao>> consultaTransacao() {
        return ResponseEntity.ok().body(transacaoService.consultar());
    }

    @ApiOperation(value = "Deleta uma transação")
    @DeleteMapping
    public  ResponseEntity<Void> deletarTransacao(){
        transacaoService.apagar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
