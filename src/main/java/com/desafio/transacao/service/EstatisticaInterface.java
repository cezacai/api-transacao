package com.desafio.transacao.service;

import com.desafio.transacao.entity.Estatistica;
import com.desafio.transacao.entity.Transacao;

import java.util.List;

public interface EstatisticaInterface {

    Estatistica gerarEstatistica(List<Transacao> transacoes);
}
