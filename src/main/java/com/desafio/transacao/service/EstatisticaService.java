package com.desafio.transacao.service;

import com.desafio.transacao.entity.Estatistica;
import com.desafio.transacao.entity.Transacao;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;


@Service
public class EstatisticaService implements EstatisticaInterface{

    private Environment environment;

    public EstatisticaService(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Estatistica gerarEstatistica(List<Transacao> transacoes) {
        Estatistica estatistica = new Estatistica();

        OffsetDateTime horarioAtual = OffsetDateTime.now();
        OffsetDateTime tempoConsulta = horarioAtual.minusSeconds(Long.parseLong(Objects.requireNonNull(environment.getProperty("tempo.estatistica"))));

        DoubleSummaryStatistics stats = transacoes
                .stream()
                .filter(transacao -> transacao.getDataHora()
                .isAfter(tempoConsulta) && transacao.getDataHora().isBefore(horarioAtual))
                .mapToDouble(Transacao ::getValor)
                .summaryStatistics();

        estatistica.setAvg(stats.getAverage());
        estatistica.setCount(stats.getCount());
        estatistica.setMax(stats.getMax());
        estatistica.setMin(stats.getMin());
        estatistica.setSum(stats.getSum());

        return estatistica;
    }
}
