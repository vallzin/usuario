package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero", length = 20)
    private String numero;
    @Column(name = "complemento", length = 150)
    private String complemento;
    @Column(name = "bairro", length = 100)
    private String bairro;
    @Column(name = "cidade", length = 150)
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "cep", length = 9)
    private String cep;

    public Endereco(){}

    public Endereco(String rua,
                    String numero,
                    String complemento,
                    String bairro,
                    String cidade,
                    String estado,
                    String cep){
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getRua(){ return rua; }

    public void setRua(String rua){ this.rua = rua; }

    public String getNumero(){ return numero; }

    public void setNumero(String numero){ this.numero = numero; }

    public String getComplemento(){ return complemento; }

    public void setComplemento(String complemento){ this.complemento = complemento; }

    public String getBairro(){ return bairro; }

    public void setBairro(String bairro){ this.bairro = bairro; }

    public String getCidade(){ return cidade; }

    public void setCidade(String cidade){ this.cidade = cidade; }

    public String getEstado(){ return estado; }

    public void setEstado(String estado){ this.estado = estado; }

    public String getCep(){ return cep; }

    public void setCep(String cep){ this.cep = cep; }
}
