package com.desafio.transacao.service;

import com.desafio.transacao.entity.Transacao;

import java.util.Collection;
import java.util.List;

public interface TransacaoInterface {
    void salvar(Transacao transacao) throws Exception;

    List<Transacao> consultar();

    void apagar();

}

