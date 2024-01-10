package com.SeuJogo.Steam.model.jogo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcompra;
    private Date dataCompra;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private Jogo jogo;

    public Compra(Date dataCompra, Usuario usuario, Jogo jogo) {
        this.dataCompra = dataCompra;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public Compra() {

    }

    public Compra(DadosCadastroCompra dcompra) {
        this.dataCompra = dcompra.dataCompra();
        this.usuario = dcompra.usuario();
        this.jogo = dcompra.jogo();
    }

    public Long getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Long idCompra) {
        this.idcompra = idcompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

}
