package br.com.gefic.gefic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private String nome;
    private String numeroTelefone;
    @Email
    private  String email;
    @Column(name = "endereço")
    private String endereco;
    private String bairro;
    private String cidade;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente(){

    }

    public Cliente(Long id, String nome, String numeroTelefone, String email, String endereco, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }


    public Long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}


