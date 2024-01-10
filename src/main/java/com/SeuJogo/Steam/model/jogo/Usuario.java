package com.SeuJogo.Steam.model.jogo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String username;
    private String cpf;
    private String senha;

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    @OneToMany(mappedBy = "usuario")
    private List<Compra> listaCompras = new ArrayList<>();


    public Usuario(DadosCadastroUsuario dUser) {
        this.username = dUser.username();
        this.cpf = dUser.cpf();
        this.senha = dUser.senha();
    }

    public Usuario() {

    }

    public void atualizaDados(DadosAlteraUsuario dUser) {
        this.username = dUser.username();
        this.cpf = dUser.cpf();
        this.senha = dUser.senha();
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
