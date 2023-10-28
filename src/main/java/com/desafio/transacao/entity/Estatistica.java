package com.desafio.transacao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Estatistica {
    private double count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
