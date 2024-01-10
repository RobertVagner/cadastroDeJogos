package com.SeuJogo.Steam.model.jogo;

import java.util.Date;

public record DadosCadastroCompra(Date dataCompra, Usuario usuario, Jogo jogo) {
}
