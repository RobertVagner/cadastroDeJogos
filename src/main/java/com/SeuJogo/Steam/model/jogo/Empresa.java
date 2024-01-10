package com.SeuJogo.Steam.model.jogo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempresa;

    @OneToMany(mappedBy = "empresa")
    private List<Jogo> listaJogos;
    private String nomeEmpresa;

    public Empresa() {

    }

    public Empresa(DadosCadastraEmpresa e) {
        this.nomeEmpresa = e.nomeEmpresa();
    }

    public void atualizaDados(DadosAlteraEmpresa dempresa) {

        this.nomeEmpresa = dempresa.nomeEmpresa();
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(List<Jogo> listaJogos) {
        this.listaJogos = listaJogos;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
