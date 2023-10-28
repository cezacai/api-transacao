package com.desafio.transacao.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Transacao {
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###.###")
    private Double valor;
    @NotNull
    private OffsetDateTime dataHora;
}
