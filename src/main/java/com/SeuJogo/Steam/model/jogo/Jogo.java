package com.SeuJogo.Steam.model.jogo;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;
    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    @OneToMany(mappedBy = "jogo")
    private List<Compra> listaCompras = new ArrayList<>();


    public Jogo(DadosCadastroJogo djogo) {
        this.nome = djogo.nome();
        this.descricao = djogo.descricao();
        this.preco = djogo.preco();
        this.genero = djogo.genero();
        this.empresa = djogo.empresa();
    }

    public Jogo(String nome, String descricao, Double preco, Genero genero, Empresa empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.genero = genero;
        this.empresa = empresa;
    }

    public Jogo(){

    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Genero getGenero() {
        return genero;
    }

    public Empresa getEmpresa() {return empresa;}

    public void atualizaDados(DadosAlteraJogo djogo){
        this.nome = djogo.nome();
        this.descricao = djogo.descricao();
        this.preco = djogo.preco();
        this.genero = djogo.genero();
        this.empresa = djogo.empresa();
    }
}
