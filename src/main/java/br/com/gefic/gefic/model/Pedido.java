package br.com.gefic.gefic.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
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

    public Pedido(Long id, Date dataDaCompra, Date dataDaUltimaTroca, Date dataDoVencimento) {
        this.id = id;
        this.dataDaCompra = dataDaCompra;
        this.dataDaUltimaTroca = dataDaUltimaTroca;
        this.dataDoVencimento = dataDoVencimento;
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


}
