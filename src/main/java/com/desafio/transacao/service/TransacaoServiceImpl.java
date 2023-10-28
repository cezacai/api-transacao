package com.desafio.transacao.service;

import com.desafio.transacao.entity.Transacao;
import com.desafio.transacao.exception.TransacaoInvalidaException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoInterface {

    private List<Transacao> transacoesEfetuadas = new ArrayList<>();

    @Override
    public void salvar(Transacao transacao) throws TransacaoInvalidaException {
        if (transacaoValida(transacao)){
            transacoesEfetuadas.add(transacao);
        }
    }

    @Override
    public List<Transacao> consultar() {
        return transacoesEfetuadas;
    }

    @Override
    public void apagar() {
        transacoesEfetuadas.clear();
    }


    private boolean transacaoValida(Transacao transacao) throws TransacaoInvalidaException {
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) throw new TransacaoInvalidaException();

        if (transacao.getValor() < 0) throw new TransacaoInvalidaException();
        return true;
    }

}



