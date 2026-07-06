package br.com.gefic.gefic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @NotBlank
    private String nomeDoProduto;
    @Column(name = "Data_da_Compra")
    private Date dataDaCompra;
    @Column(name = "Data_da_Última_Troca")
    private Date dataDaUltimaTroca;
    @Column(name = "Data_do_Vencimento")
    private Date dataDoVencimento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido(){

    };

    public Pedido(Long id, Date dataDaCompra, Date dataDaUltimaTroca, Date dataDoVencimento, String nomeDoProduto) {
        this.id = id;
        this.dataDaCompra = dataDaCompra;
        this.dataDaUltimaTroca = dataDaUltimaTroca;
        this.dataDoVencimento = dataDoVencimento;
        this.nomeDoProduto = nomeDoProduto;
    }


    public Long getId(){
        return id;
    }


    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public Date getDataDaUltimaTroca() {
        return dataDaUltimaTroca;
    }

    public Date getDataDoVencimento() {
        return dataDoVencimento;
    }

    public String getNomeDoProduto(){
        return nomeDoProduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public void setDataDaUltimaTroca(Date dataDaUltimaTroca) {
        this.dataDaUltimaTroca = dataDaUltimaTroca;
    }

    public void setDataDoVencimento(Date dataDoVencimento) {
        this.dataDoVencimento = dataDoVencimento;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
