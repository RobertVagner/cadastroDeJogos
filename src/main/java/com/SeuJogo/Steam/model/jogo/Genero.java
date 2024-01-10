package com.SeuJogo.Steam.model.jogo;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="generos")

public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgenero;
    private String nomeGenero;

    @OneToMany(mappedBy = "genero")
    private List<Jogo> listaJogos = new ArrayList<>();

    public Genero(){

    }
    public Genero(DadosCadastroGenero djogo) {
        this.nomeGenero = djogo.nomeGenero();
    }
    public void atualizaDados(DadosAlteraGenero dgenero) {

        this.nomeGenero = dgenero.nomeGenero();
    }

    public Long getIdgenero() {
        return idgenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }
}
